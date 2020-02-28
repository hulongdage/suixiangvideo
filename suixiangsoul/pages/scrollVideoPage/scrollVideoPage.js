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
  /**
   * 页面的初始数据
   */
  data: {
    showNum:0,
    setTimer: '', //   设置定时器
    showDanmuList: [],
    videoDetail: '',
    start: 0,
    current: 0,
    startTouch: '',
    startNum: '0',
    //其中的 视频url(videoUrl) 封面url(videoImageUrl) 头像url(headUrl) 的话大家自己填上就行
    videoList: [], //接口返回的视频列表。
    touch: false,
    touchStartTime: 0, //触摸开始时间
    touchEndTime: 0, // 触摸结束时间
    lastTapTime: 0, // 单击事件点击后要触发的函数
    lastTapTimeoutFunc: null,
    switchTo: true,
    userLoveVideo: false,
    commentsPage: 1,
    commentsTotalPage: 1,
    commentsList: [],
    placeholder: "说点什么..."
  },
  
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function () {
    var that = this;
    var serverUrl = app.serverUrl;
    var listTem = that.data.videoList;
    for (var i = 0; i < listTem.length; i++) {
      var arr = (listTem[i].quickProjectWorkerTagName).split(',')
      listTem[i].tagnamesArr = arr;
    }
    that.setData({
      videoList: listTem,
      serverUrl: serverUrl
    })
    //获取视频列表数据
    that.dataList();
  },
  startGetDanmu: function(){
    var that = this; 
    that.setData({
      showDanmuList: [],
      setTimer: setTimeout(function () {
        var visionseconds = that.data.visionseconds;
        var danmuList = that.data.danmuList;
        var danmuNum = that.data.danmuNum;
        var time = (visionseconds - 1.5) / (danmuNum);
        var data = [];
        danmuList.forEach(function (c, i) {
          var obj = {
            text: danmuList[i],
            color: getRandomColor(),
            time: parseInt(time * i + 1.5)
          }
          data.push(obj)
        })
        console.log(data)
        that.setData({
          showDanmuList: data
        })
      }, 1500)
    })
    
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    this.videoContext = wx.createVideoContext('videoplayer');
    this.setData({
      updateState: true
    })
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    var that = this;
    var showNum = that.data.showNum;
    if (showNum === 1) {
      that.setData({
        showNum: 0
      })
      wx.reLaunch({
        url: '../scrollVideoPage/scrollVideoPage',
      })
    }
  },
  

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
    var that = this;
    that.setData({
      showNum: 1
    })
    that.videoContext.pause();
   // that.dataList();
  },
  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },
  dataList: function () {//加载数据
    var that = this;
    var serverUrl = app.serverUrl;
    var user = app.getGlobalUserInfo();
    var userId = user.id;
    wx.request({
      url: serverUrl + '/video/showMyFollowList?userId=' + userId,//把这里换成自己的接口地址
      method: 'POST', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
      header: {
        'content-type': 'application/x-www-form-urlencoded', // 默认值
        'usertoken': user.usertoken,
        'userId': user.id
      },
      success: function (res) {
        if (res.data.status == 200) {  
          var listTem = that.data.videoList;
          var dataList = res.data.data;
          //添加新任务列表
          that.setData({
            videoList: listTem.concat(dataList)
          })   
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
  // 下面主要模仿滑动事件
  touchstart: function (e) {
    this.setData({
      touchStartTime: e.timeStamp,
      showGuide: false
    })
    let startTouch = e.changedTouches[0]
    this.setData({
      startTouch: startTouch,
      touch: false
    })
  },
  touchmove: function (e) {
    let Y = e.changedTouches[0].pageY - this.data.startTouch.pageY;
  },
  touchend: function (e) {
    this.setData({
      touchEndTime: e.timeStamp,
    })
    this.getDirect(this.data.startTouch, e.changedTouches[0])
  },
  touchcancel: function (e) {
    this.getDirect(this.data.startTouch, e.changedTouches[0])
  },
  // 计算滑动方向
  getDirect: function (start, end) {
    var X = end.pageX - start.pageX,
    Y = end.pageY - start.pageY;
    if (Math.abs(Y) > Math.abs(X) && Y > 40) {
      if (this.data.current > 0) {
        this.setData({
          touch: true,
          transitionOver: false,
        })
        this.pre()
      } else {
        this.setData({
          current: 0
        })
      }
    }
    else if (Math.abs(Y) > Math.abs(X) && Y < -40) {
      if (this.data.current < this.data.videoList.length - 2) {
        this.setData({
          touch: true
        })
        this.next()
      } else {
        var startNum = parseInt(this.data.startNum) + 5;
        this.setData({
          startNum: startNum,
        })
        this.setData({
          current: this.data.videoList.length - 1
        })
      }
    }
  },
  // 播放上一个
  pre: function () {
    this.setData({
      current: this.data.current - 1,
    })
  },

  // 播放下一个
  next: function () {
    this.setData({
      current: this.data.current + 1,
    })
  },
  funended: function () {//播放结束按钮函数
      //  var that = this;
      //  clearInterval(that.data.setInter)
     
  },
  bindPlay: function (e) {
    var that = this;
    // if (that.data.setInter != '') {
    //   clearTimeout(that.data.setInter)
    // }
    //clearInterval(that.data.setInter)
    var arrindex = e.target.dataset.arrindex;
    var videoList = that.data.videoList;
    var videoDetail = videoList[arrindex];
    var visionseconds = videoDetail.visionseconds;
    that.setData({
      videoDetail: videoDetail,
      visionseconds: visionseconds,
    });
    var user = app.getGlobalUserInfo();
    var userId = '';
    if (user != null && user != undefined && user != '') {
      userId = user.id;
    }
    var serverUrl = app.serverUrl;
    wx.request({
      url: serverUrl + '/user/queryPublisherDetail?userId=' + userId + "&publisherId=" + videoDetail.userid + "&videoId=" + videoDetail.id,
      method: 'POST',
      success: function (res) {
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
    that.startGetDanmu()  //启动弹幕定时器
 //   that.getCommentList(1);
  },
  getCommentList: function (page) {
    var that = this;
    var videoId = that.data.videoDetail.id;
    wx.request({
      url: app.serverUrl + '/video/getVideoComments?videoId=' + videoId + '&currentPage=' + page + '&pageSize=5',
      method: 'POST',
      success: function (res) {
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
  //点击暂停/开始
  videoTap: function (e) {
    //获取video
    this.videoContext = wx.createVideoContext('videoplayer')
    if (this.data.play) {
      //开始播放
      this.videoContext.play()//开始播放
      this.setData({
        play: false
      })
    } else {
      //当play==false 显示图片 暂停
      this.videoContext.pause()//暂停播放
      this.setData({
        play: true
      })
    }
  },
  //播放条时间改表触发
  videoUpdate(e) {
    if (this.data.updateState) { //判断拖拽完成后才触发更新，避免拖拽失效
      let sliderValue = e.detail.currentTime / e.detail.duration * 100;
      this.setData({
        sliderValue: sliderValue,
        duration: e.detail.duration
      })
    }
  },
  sliderChanging(e) {
    this.setData({
      updateState: false //拖拽过程中，不允许更新进度条
    })
  },
  //拖动进度条触发事件
  sliderChange(e) {
    if (this.data.duration) {
      this.videoContext.seek(e.detail.value / 100 * this.data.duration); //完成拖动后，计算对应时间并跳转到指定位置
      this.setData({
        sliderValue: e.detail.value,
        updateState: true //完成拖动后允许更新滚动条
      })
    }
  },
  uploadVideo: function () {
    var that = this;
    var redirectToUrl = "../scrollVideoPage/scrollVideoPage";
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
  toIndex: function () {
    wx.switchTab({
      url: '../index/index',
    })
  },
  toUserDetail: function () {
    var userInfo = app.getGlobalUserInfo();
    if (userInfo == null || userInfo == '' || userInfo == undefined) {
      wx.navigateTo({
        url: '../login/login',
      })
    } else {
      wx.reLaunch({
        url: '../detailBar/detailBar',
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
  loveVideoOrNot: function () {
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
      if (userLoveVideo) {
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
        success: function (res) {
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
  replyFocus: function (e) {
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
  saveComment: function (e) {
    var that = this;
    var commentContent = e.detail.value;
    if (commentContent == null || commentContent == '' || commentContent == undefined) {
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
        data: {
          fromuserid: userInfo.id,
          //visionid: videoInfo.id,
          visionid: that.data.videoDetail.id,
          comment: commentContent
        },
        success: function (res) {
          that.setData({
            contentValue: '',
            commentsList: []
          });
          that.getCommentList(1);
        }
      })
    }
  },
  shareVideo: function () {
    var that = this;
    var userInfo = app.getGlobalUserInfo();
    wx.showActionSheet({
      itemList: ['下载到本地', '举报用户', '分享到朋友圈', '分享到QQ空间', '分享到微博'],
      success: function (res) {
        //下载到本地
        if (res.tapIndex == 0) {
          wx.showLoading({
            title: '下载中...',
          })
          wx.downloadFile({
            url: app.serverUrl + that.data.videoDetail.visionpath,
            success: function (res) {
              // 只要服务器有响应数据，就会把响应内容写入文件并进入 success 回调，业务需要自行判断是否下载到了想要的内容
              if (res.statusCode === 200) {
                wx.saveVideoToPhotosAlbum({
                  filePath: res.tempFilePath,
                  success: function (res) {
                    wx.hideLoading();
                  }
                })
              }
            }
          })
        } else if (res.tapIndex == 1) {
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
  
})