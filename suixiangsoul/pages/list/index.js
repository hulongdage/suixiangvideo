Page({
  //事件处理函数
  onLoad: function (options) {
    this.title = options.type || '产品服务'
  },
  onReady: function () {
    wx.setNavigationBarTitle({
      title: this.title
    })
  },
  
})
