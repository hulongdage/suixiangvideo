const app = getApp()
Page({
  data: {
   
  },
  onLoad: function (params) {
    var that = this;
    var serverUrl = app.serverUrl;
    wx.redirectTo({
      url: '../component/index',
    })
  },
})