var videoUploadUtil = require("../../util/videoUploadUtil.js")

const app = getApp()
function getRandomColor() {
  let rgb = []
  for (let i = 0; i < 3; ++i) {
    let color = Math.floor(Math.random() * 256).toString(16)
    color = color.length == 1 ? '0' + color : color
    rgb.push(color)
  }
  return '#' + rgb.join('')
}


Page({
  data: {
    cover: "cover",
    videoId: "",
    src: "",
    videoDetail: {} ,
    userLoveVideo: false,
    commentsPage: 1,
    commentsTotalPage: 1,
    commentsList: [],

    placeholder: "说点什么..."
  },
  videoContext: {},

  onLoad: function (params) {  
    var that = this;   
    var serverUrl = app.serverUrl;
    that.videoContext = wx.createVideoContext("videoDetail", that);
    //获取上个页面传递的视频信息
    var videoDetail = JSON.parse(params.videoDetail);
    var visionwidth = videoDetail.visionwidth;
    var visionheight = videoDetail.visionheight;
    var visionseconds = videoDetail.visionseconds;
    var cover= "cover";
    if (visionwidth >= visionheight){
      cover = "";
    }
    that.setData({
      videoId: videoDetail.id,
      src: serverUrl + videoDetail.visionpath,
      videoDetail: videoDetail,
      cover: cover,
      visionseconds: visionseconds
    });
    var user = app.getGlobalUserInfo();
    var userId = '';
    if(user != null && user != undefined && user != ''){
        userId = user.id;
    }
    wx.request({
      url: serverUrl + '/user/queryPublisherDetail?userId=' + userId + "&publisherId=" + videoDetail.userid + "&videoId=" + videoDetail.id,
      method: 'POST',
      success: function(res){
        console.log(res);
        var userVO = res.data.data.userVO;
        var userLoveVideo = res.data.data.userLoveVideo;
        var danmuList = res.data.data.danmuList;
        var danmuNum = res.data.data.danmuNum;
        that.setData({
          userVO: userVO,
          userLoveVideo: userLoveVideo,
          serverUrl: serverUrl,
          danmuList: danmuList,
          danmuNum: danmuNum
        });
      }
    })
    that.getCommentList(1);
  },
  bindPlay:function(e){
    
    var that = this;
    that.videoContext.play();
    setTimeout(function(){
      var visionseconds = that.data.visionseconds;
      var danmuList = that.data.danmuList;
      var danmuNum = that.data.danmuNum;
      var time = (visionseconds - 1.5) / (danmuNum);
     // console.log(time);
      var data = [];
      danmuList.forEach(function(c,i){
     //  console.log(danmuList[i]);
        var obj = {
          text: danmuList[i],
          color: getRandomColor(),
          time: parseInt(time*i + 1.5)
        }
        data.push(obj)
      })
       console.log(data)
       that.setData({
         showDanmuList: data
       })
    },1500)
  },
  onShow:function(){
    var that = this; 
    that.videoContext.play();
  },
  onHide:function(){
    var that = this; 
    that.videoContext.pause();
  },
  uploadVideo:function(){
    var that = this;
    var videoDetail = JSON.stringify(that.data.videoDetail);
    var redirectToUrl = "../videodetail/videodetail#videoDetail@" + videoDetail;
    var userInfo = app.getGlobalUserInfo();
    if (userInfo == null || userInfo == '' || userInfo == undefined) {
      wx.navigateTo({
        url: '../login/login?redirectUrl=' + redirectToUrl,
      })
    } else {    
        videoUploadUtil.uploadVideo();
    }
    
  },
  showSearch: function () {
    wx.navigateTo({
      url: '../searchVideo/searchVideo',
    })
  },
  toIndex: function(){
    wx.switchTab({
      url: '../index/index',
    })
  },
  toUserDetail: function(){
    var userInfo = app.getGlobalUserInfo();
    if (userInfo == null || userInfo == '' || userInfo == undefined){
      wx.navigateTo({
        url: '../login/login',
      })
    }else{
      wx.navigateTo({
        url: '../detail/detail', 
      })
    }  
  },
  toPublisherDetail: function () {
    var that = this;
    var videoDetail = that.data.videoDetail;
    var redirectToUrl = "../detail/detail#publisherId@" + videoDetail.userid;
    var userInfo = app.getGlobalUserInfo();
    if (userInfo == null || userInfo == '' || userInfo == undefined) {
      wx.navigateTo({
        url: '../login/login?redirectUrl=' + redirectToUrl,
      })
    } else {
      wx.navigateTo({
        url: '../detail/detail?publisherId=' + videoDetail.userid,
      })
    }

  },
  loveVideoOrNot: function(){
    var that = this;
    var userInfo = app.getGlobalUserInfo();
    var videoDetail = that.data.videoDetail;
    if (userInfo == null || userInfo == '' || userInfo == undefined) {
      wx.navigateTo({
        url: '../login/login',
      })
    } else {
      var serverUrl = app.serverUrl;
      var userLoveVideo = that.data.userLoveVideo;
      var requestUrl = "/video/userLoveVideo?userId=" + userInfo.id + "&videoId=" + videoDetail.id + "&publisherId=" + videoDetail.userid;
      if(userLoveVideo){
          requestUrl = "/video/userDisLoveVideo?userId=" + userInfo.id + "&videoId=" + videoDetail.id + "&publisherId=" + videoDetail.userid;
      }
      wx.request({
        url: serverUrl + requestUrl,
        method: "POST",
        header: {
          'content-type': 'application/json',
          'usertoken': userInfo.usertoken,
          'userId': userInfo.id
        },
        success: function(res){
           that.setData({
             userLoveVideo: !userLoveVideo
           });
        }
      }) 
    }
  },
  writeComment: function () {
    this.setData({
      commentFocus: true
    });
  },
  replyFocus: function(e){
    var fatherCommentId = e.currentTarget.dataset.fathercommentid;
    var toUserId = e.currentTarget.dataset.touserid;
    var toNickname = e.currentTarget.dataset.tonickname;
    this.setData({
      placeholder: "回复  " + toNickname,
      replyFatherCommentId: fatherCommentId,
      replyToUserId: toUserId,
      commentFocus: true
    });
  },
  saveComment: function(e){
    var that = this;
    var commentContent = e.detail.value;
    if (commentContent == null || commentContent == '' || commentContent == undefined){
      wx.showToast({
        title: '请输入些什么吧',
        duration: 3000,
        icon: 'none'
      })
      return;
    }
    // 获取评论回复的fatherCommentId和toUserId
    var fatherCommentId = e.currentTarget.dataset.replyfathercommentid;
    var toUserId = e.currentTarget.dataset.replytouserid;
    var videoInfo = JSON.stringify(that.data.videoDetail);
    var redirectToUrl = "../videodetail/videodetail#videoDetail@" + videoInfo;
    var userInfo = app.getGlobalUserInfo();
    if (userInfo == null || userInfo == '' || userInfo == undefined) {
      wx.navigateTo({
        url: '../login/login?redirectUrl=' + redirectToUrl,
      })
    } else {
      wx.request({
        url: app.serverUrl + '/video/saveComment?fatherCommentId=' + fatherCommentId + "&toUserId=" + toUserId,
        method: 'POST',
        header: {
          'content-type': 'application/json',
          'usertoken': userInfo.usertoken,
          'userId': userInfo.id
        },
        data:{
          fromuserid: userInfo.id,
          //visionid: videoInfo.id,
          visionid: that.data.videoDetail.id,
          comment: commentContent
        },
        success: function(res){
          console.log(res.data);
          that.setData({
            contentValue: '',
            commentsList: []
          });
          that.getCommentList(1);
        }
      })
    }
  },
  shareVideo: function(){
    var that = this;
    var userInfo = app.getGlobalUserInfo();
    wx.showActionSheet({
      itemList: ['下载到本地', '举报用户', '分享到朋友圈', '分享到QQ空间', '分享到微博'],
      success: function (res) {
        //下载到本地
        if(res.tapIndex == 0){
          wx.downloadFile({
            url: app.serverUrl + that.data.videoDetail.visionpath,
            success: function (res) {
              // 只要服务器有响应数据，就会把响应内容写入文件并进入 success 回调，业务需要自行判断是否下载到了想要的内容
              if (res.statusCode === 200) {
                console.log(res.tempFilePath);
                wx.saveVideoToPhotosAlbum({
                  filePath: res.tempFilePath,
                  success: function (res) {
                    console.log(res.errMsg)
                    
                  }
                })
              }
            }
          })
        }else if(res.tapIndex == 1){ 
          //举报用户
          var videoInfo = JSON.stringify(that.data.videoDetail);
          var redirectToUrl = "../videodetail/videodetail#videoDetail@" + videoInfo;
          var userInfo = app.getGlobalUserInfo();
          if (userInfo == null || userInfo == '' || userInfo == undefined) {
            wx.navigateTo({
              url: '../login/login?redirectUrl=' + redirectToUrl,
            })
          } else {
            var publishUserId = that.data.videoDetail.userid;
            var videoId = that.data.videoDetail.id;
            var currentUserId = userInfo.id;
            wx.navigateTo({
              url: '../tipUser/tipUser?reportvisionid=' + videoId + '&reportuserid=' + publishUserId,
            })
          }
        } else {
          wx.showToast({
            title: '官方暂未开放...',
          })
        }
      }
    });
  },
  onShareAppMessage: function (res) {
    var that = this;
    var videoDetail = that.data.videoDetail;
    return {
      title: '短视频内容分析',
      path: "pages/videodetail/videodetail?videoDetail=" + JSON.stringify(videoDetail)
    }
  },
  getCommentList: function(page){
    var that = this;
    var videoId = that.data.videoDetail.id;
    wx.request({
      url: app.serverUrl + '/video/getVideoComments?videoId=' + videoId + '&currentPage=' + page + '&pageSize=5',
      method: 'POST',
      success: function(res){
        var commentsList = res.data.data.rows;
        var newCommentList = that.data.commentsList;
        that.setData({
          commentsList: newCommentList.concat(commentsList),
          commentsPage: page,
          commentsTotalPage: res.data.data.totalPage
        });
      }
    })
  },
  onReachBottom: function () {
    var that = this;
    var currentPage = that.data.commentsPage;
    var totalPage = that.data.commentsTotalPage;
    if (currentPage === totalPage) {
      wx.showToast({
        title: '没有留言了',
        icon: 'none'
      })
      return;
    }
    var nextPage = currentPage + 1;
    that.getCommentList(nextPage);
  }
})