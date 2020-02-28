const app = getApp()

Page({
    data:{
      bgmList: [],
      serverUrl: "",
      videoParams: {}
    },
  onLoad: function (params) {
    console.log(params);
    var me = this;
    me.setData({
      videoParams: params
    });
    wx.showLoading({
      title: '请稍候...',
    })
    var serverUrl = app.serverUrl; 
    var userInfo = app.getGlobalUserInfo();
    // 调用后端
    wx.request({
      url: serverUrl + '/bgm/queryBgmList',
      method: "POST",
      header: {
        'content-type': 'application/json',
        'usertoken': userInfo.usertoken,
        'userId': userInfo.id
      },
      success: function (res) {
        wx.hideLoading();
        if (res.data.status == 200) {
          var bgmList = res.data.data;   
          me.setData({
            bgmList: bgmList,
            serverUrl: serverUrl
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
  uploadVideo: function(e){
    var me = this;
    var bgmId = e.detail.value.bgmId;
    var desc = e.detail.value.desc;
    var duration = me.data.videoParams.duration;
    var tmpHeight = me.data.videoParams.tmpHeight;
    var tmpWidth = me.data.videoParams.tmpWidth;
    var tmpVideoUrl = me.data.videoParams.tmpVideoUrl;
    var tmpCoverUrl = me.data.videoParams.tmpCoverUrl;
    //上传视频
    wx.showLoading({
      title: '视频上传中...',
    })
    var serverUrl = app.serverUrl; 
    var userInfo = app.getGlobalUserInfo();
    wx.uploadFile({
      url: serverUrl + '/video/uploadVideo',
      formData:{
      //  userId: app.userInfo.id,
        userId: userInfo.id,
        bgmId: bgmId,
        videoSeconds: duration,
        videoHeight: tmpHeight,
        videoWidth: tmpWidth,
        desc: desc
      },
      filePath: tmpVideoUrl,
      name: 'file',
      header: {
        'content-type': 'application/json', // 默认值
        'usertoken': userInfo.usertoken,
        'userId': userInfo.id
      },
      success: function (res) {
        var data = JSON.parse(res.data);
        wx.hideLoading();
        if (data.status == 200) {
          wx.showToast({
            title: '视频上传成功',
            icon: 'success'
          });
          wx.navigateBack({
            delta: 1
          })
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

