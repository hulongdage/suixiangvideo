//获取应用实例
var app = getApp()
Page({
  data: {
   
    },
  onLoad: function (params) {
    var me = this;
    var user = app.getGlobalUserInfo();
    var userId = user.id;
    var currentPage = 1;
    if (params.currentPage != null){
        currentPage = JSON.parse(params.currentPage);
      console.log(currentPage)
    }
    
    // 调用后端
    var serverUrl = app.serverUrl;
    wx.request({
      url: serverUrl + '/video/showMyFollow/?userId=' + userId + '&currentPage' + currentPage,
      method: "POST",
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        //  console.log(res.data);
        var followVideoList = res.data.data.rows;
        var videoDetail = followVideoList[0];
        var videoInfo = JSON.stringify(videoDetail);

        wx.redirectTo({
          url: '../index2/index?videoInfo=' + videoInfo + '&currentPage=' + res.data.data.currentPage + '&totalPage=' + res.data.data.totalPage
        })
        // wx.hideLoading();
        // me.setData({
        //   videoDetail: videoDetail,
        //   followVideoList: followVideoList,
        //   followVideoPage: page,
        //   followVideoTotal: res.data.data.totalPage,
        //   serverUrl: app.serverUrl
        // });
      }
    })
  },
  })