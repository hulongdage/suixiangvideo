var videoUploadUtil = require("../../util/videoUploadUtil.js")
const app = getApp()

Page({
  data: {
    headImage: "../resource/images/noneface.png",
    isMyself: true,
    isCon: false,
    videoSelClass: "video-info",
    isSelectedWork: "video-info-selected",
    isSelectedLike: "",
    isSelectedFollow: "",
    myVideoList: [],
    myVideoPage: 1,
    myVideoTotal: 1,

    likeVideoList: [],
    likeVideoPage: 1,
    likeVideoTotal: 1,

    followVideoList: [],
    followVideoPage: 1,
    followVideoTotal: 1,

    myWorkFalg: false,
    myLikesFalg: true,
    myFollowFalg: true
  },
  onLoad: function (params) {
    var me = this;
    // var userInfo = app.userInfo;
    var userInfo = app.getGlobalUserInfo();
    var userId = userInfo.id;
    var publisherId = params.publisherId;
    if (publisherId != null && publisherId != '' && publisherId != undefined && publisherId != userId){
       userId = publisherId;  
       me.setData({
         isMyself: false,
         publisherId: publisherId
       }); 
    }
    me.setData({
      userId: userId
    })
    wx.showLoading({
      title: '请稍候...',
    })
    var serverUrl = app.serverUrl;
    // 调用后端
    wx.request({
      url: serverUrl + '/user/queryUserDetail?userId=' + userId + '&fansId=' + userInfo.id,
      method: "POST",
      header: {
        'content-type': 'application/json',
        'usertoken': userInfo.usertoken,
        'userId': userInfo.id
      },
      success: function (res) {
        wx.hideLoading();
        if (res.data.status == 200) {     
          var userDetail = res.data.data;
          var headImage = "../resource/images/noneface.png";
          if (userDetail.headimage != null && userDetail.headimage != '' 
            && userDetail.headimage != undefined){
               headImage = serverUrl + userDetail.headimage;
            }          
          me.setData({
            headImage: headImage,
            countfan: userDetail.countfan,
            countcon: userDetail.countcon,
            countlove: userDetail.countlove,
            nickname: userDetail.nickname,
            isCon: userDetail.concern       //实体类属性名为例如 isConcern 前端收到为concern
          });
        } else if (res.data.status == 502){
          wx.showToast({
            title: res.data.msg,
            duration: 3000,
            icon: "none",
            success: function(){
              wx.redirectTo({
                url: '../login/login',
              })
            }
          })
        }
      }
    })
    me.getMyVideoList(1);
  },
  concernMe: function(e){
    var that = this;
    var publisherId = that.data.publisherId;
    var userInfo = app.getGlobalUserInfo();
    var userId = userInfo.id;
    var concernType = e.currentTarget.dataset.concerntype; //不支持大写
    //判断是关注还是取消关注
    var requestUrl = '';
    if(concernType == '0'){
      requestUrl = '/user/delUserFansRelation?userId=' + publisherId + '&fansId=' + userId;
    }else{
      requestUrl = '/user/addUserFansRelation?userId=' + publisherId + '&fansId=' + userId;
    }
    wx.request({
      url: app.serverUrl + requestUrl,
      method: 'POST',
      header: {
        'content-type': 'application/json',
        'usertoken': userInfo.usertoken,
        'userId': userInfo.id
      },
      success:function(){
        if (concernType == '0'){
          that.setData({
            isCon: false,
            countfan: --that.data.countfan
          });
        }else{
          that.setData({
            isCon: true,
            countfan: ++that.data.countfan
          });
        }
        
      }
    })
  },
  logout: function(){
   // var userInfo = app.userInfo;
    var userInfo = app.getGlobalUserInfo();
    var serverUrl = app.serverUrl;
    wx.showLoading({
      title: '请稍候...',
    })
    // 调用后端
    wx.request({
      url: serverUrl + '/logout?userId=' + userInfo.id,
      method: "POST",
      data: {
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        console.log(res.data);
        wx.hideLoading();
        if (res.data.status == 200) {
          wx.showToast({
            title: '注销成功',
            icon: 'success',
            duration: 2000
          });
        //  app.userInfo = null;
          wx.removeStorageSync("userInfo");
          // 注销成功跳转
          wx.reLaunch({
            url: '../login/login',
          })                 
        }
      }
    })
  },
  changeHeadImage: function(){
    var me = this;
    wx.chooseImage({
      count: 1,
      sizeType: ['compressed'],
      sourceType: ['album'],
      success: function(res) {
        var tempFilePaths = res.tempFilePaths;
        var serverUrl = app.serverUrl;
        var userInfo = app.getGlobalUserInfo();
        wx.showLoading({
          title: '头像上传中...',
        })
        wx.uploadFile({
          url: serverUrl + '/user/uploadHeadImage?userId=' + userInfo.id,
          filePath: tempFilePaths[0],
          name: 'file',
          header: {
            'content-type': 'application/json', // 默认值
            'usertoken': userInfo.usertoken,
            'userId': userInfo.id
          },
          success: function(res){
            var data = JSON.parse(res.data);
             wx.hideLoading();
             if(data.status == 200){
               wx.showToast({
                 title: '头像上传成功',
                 icon: 'success'
               });
               var headImagePath = data.data; 
               me.setData({
                 headImage: serverUrl + headImagePath
               });
             } else if (data.status == 500){
               wx.showToast({
                 title: data.msg
               });
             } else if (data.status == 502) {
               wx.showToast({
                 title: data.msg,
                 duration: 3000,
                 icon: "none",
                 success: function () {
                   wx.redirectTo({
                     url: '../login/login',
                   })
                 }
               })
             }            
          }
        })
      }
    })
  },
  uploadVideo: function(){
    videoUploadUtil.uploadVideo();
  },
  doSelectWork: function () {
    this.setData({
      isSelectedWork: "video-info-selected",
      isSelectedLike: "",
      isSelectedFollow: "",

      myWorkFalg: false,
      myLikesFalg: true,
      myFollowFalg: true,

      myVideoList: [],
      myVideoPage: 1,
      myVideoTotal: 1,

      likeVideoList: [],
      likeVideoPage: 1,
      likeVideoTotal: 1,

      followVideoList: [],
      followVideoPage: 1,
      followVideoTotal: 1
    });

    this.getMyVideoList(1);
  },

  doSelectLike: function () {
    this.setData({
      isSelectedWork: "",
      isSelectedLike: "video-info-selected",
      isSelectedFollow: "",

      myWorkFalg: true,
      myLikesFalg: false,
      myFollowFalg: true,

      myVideoList: [],
      myVideoPage: 1,
      myVideoTotal: 1,

      likeVideoList: [],
      likeVideoPage: 1,
      likeVideoTotal: 1,

      followVideoList: [],
      followVideoPage: 1,
      followVideoTotal: 1
    });

    this.getMyLikesList(1);
  },

  doSelectFollow: function () {
    this.setData({
      isSelectedWork: "",
      isSelectedLike: "",
      isSelectedFollow: "video-info-selected",

      myWorkFalg: true,
      myLikesFalg: true,
      myFollowFalg: false,

      myVideoList: [],
      myVideoPage: 1,
      myVideoTotal: 1,

      likeVideoList: [],
      likeVideoPage: 1,
      likeVideoTotal: 1,

      followVideoList: [],
      followVideoPage: 1,
      followVideoTotal: 1
    });

    this.getMyFollowList(1)
  },

  getMyVideoList: function (page) {
    var me = this;
    var user = app.getGlobalUserInfo();
    console.log(me.data.userId);
    // 查询视频信息
    wx.showLoading();
    // 调用后端
    var serverUrl = app.serverUrl;
    wx.request({
      url: serverUrl + '/video/searchVideo?currentPage=' + page + '&pageSize=6',
      method: "POST",
      data: {
        userid: me.data.userId
      },
      header: {
        'content-type': 'application/json', // 默认值
        'usertoken': user.usertoken,
        'userId': user.id
      },
      success: function (res) {
        console.log(res.data);
        if (res.data.status == 200) {
          var myVideoList = res.data.data.rows;
          wx.hideLoading();
          var newVideoList = me.data.myVideoList;
          me.setData({
            myVideoPage: page,
            myVideoList: newVideoList.concat(myVideoList),
            myVideoTotal: res.data.data.totalPage,
            serverUrl: app.serverUrl
          });
        } else if (res.data.status == 502) {
          wx.showToast({
            title: res.data.msg,
            duration: 3000,
            icon: "none",
            success: function () {
              wx.redirectTo({
                url: '../login/login',
              })
            }
          })
        }

      }
    })
  },
  getMyLikesList: function (page) {
    var me = this;
    var userId = me.data.userId;
    var user = app.getGlobalUserInfo();
    // 查询视频信息
    wx.showLoading();
    // 调用后端
    var serverUrl = app.serverUrl;
    wx.request({
      url: serverUrl + '/video/showMyLike?userId=' + userId + '&currentPage=' + page + '&pageSize=6',
      method: "POST",
      header: {
        'content-type': 'application/json', // 默认值
        'usertoken': user.usertoken,
        'userId': user.id
      },
      success: function (res) {
        console.log(res.data);
        if (res.data.status == 200) {
          var likeVideoList = res.data.data.rows;
          wx.hideLoading();
          var newVideoList = me.data.likeVideoList;
          me.setData({
            likeVideoPage: page,
            likeVideoList: newVideoList.concat(likeVideoList),
            likeVideoTotal: res.data.data.totalPage,
            serverUrl: app.serverUrl
          });
        } else if (res.data.status == 502) {
          wx.showToast({
            title: res.data.msg,
            duration: 3000,
            icon: "none",
            success: function () {
              wx.redirectTo({
                url: '../login/login',
              })
            }
          })
        }
      }

    })
  },
  getMyFollowList: function (page) {
    var me = this;
    var userId = me.data.userId;
    var user = app.getGlobalUserInfo();
    // 查询视频信息
    wx.showLoading();
    // 调用后端
    var serverUrl = app.serverUrl;
    wx.request({
      url: serverUrl + '/video/showMyFollow?userId=' + userId + '&currentPage=' + page + '&pageSize=6',
      method: "POST",
      header: {
        'content-type': 'application/json', // 默认值
        'usertoken': user.usertoken,
        'userId': user.id
      },
      success: function (res) {
        console.log(res.data);
        if (res.data.status == 200) {
          var followVideoList = res.data.data.rows;
          wx.hideLoading();
          var newVideoList = me.data.followVideoList;
          me.setData({
            followVideoPage: page,
            followVideoList: newVideoList.concat(followVideoList),
            followVideoTotal: res.data.data.totalPage,
            serverUrl: app.serverUrl
          });
        } else if (res.data.status == 502) {
          wx.showToast({
            title: res.data.msg,
            duration: 3000,
            icon: "none",
            success: function () {
              wx.redirectTo({
                url: '../login/login',
              })
            }
          })
        }
      }

    })
  },
  // 点击跳转到视频详情页面
  showVideo: function (e) {
    console.log(e);
    var myWorkFalg = this.data.myWorkFalg;
    var myLikesFalg = this.data.myLikesFalg;
    var myFollowFalg = this.data.myFollowFalg;

    if (!myWorkFalg) {
      var videoList = this.data.myVideoList;
    } else if (!myLikesFalg) {
      var videoList = this.data.likeVideoList;
    } else if (!myFollowFalg) {
      var videoList = this.data.followVideoList;
    }

    var arrindex = e.target.dataset.arrindex;
    var videoInfo = JSON.stringify(videoList[arrindex]);

    wx.redirectTo({
       url: '../videodetail/videodetail?videoDetail=' + videoInfo
    })

  },

  // 到底部后触发加载
  onReachBottom: function () {
    console.log("到底部了")
    var myWorkFalg = this.data.myWorkFalg;
    var myLikesFalg = this.data.myLikesFalg;
    var myFollowFalg = this.data.myFollowFalg;

    if (!myWorkFalg) {
      var currentPage = this.data.myVideoPage;
      var totalPage = this.data.myVideoTotal;
      // 获取总页数进行判断，如果当前页数和总页数相等，则不分页
      if (currentPage === totalPage) {
        wx.showToast({
          title: '已经没有视频啦...',
          icon: "none"
        });
        return;
      }
      var page = currentPage + 1;
      this.getMyVideoList(page);
    } else if (!myLikesFalg) {
      var currentPage = this.data.likeVideoPage;
      var totalPage = this.data.myLikesTotal;
      // 获取总页数进行判断，如果当前页数和总页数相等，则不分页
      if (currentPage === totalPage) {
        wx.showToast({
          title: '已经没有视频啦...',
          icon: "none"
        });
        return;
      }
      var page = currentPage + 1;
      this.getMyLikesList(page);
    } else if (!myFollowFalg) {
      var currentPage = this.data.followVideoPage;
      var totalPage = this.data.followVideoTotal;
      // 获取总页数进行判断，如果当前页数和总页数相等，则不分页
      if (currentPage === totalPage) {
        wx.showToast({
          title: '已经没有视频啦...',
          icon: "none"
        });
        return;
      }
      var page = currentPage + 1;
      this.getMyFollowList(page);
    }

  }
})
