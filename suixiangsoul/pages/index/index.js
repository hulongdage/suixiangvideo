//index.js
//获取应用实例
var app = getApp()
Page( {
  data: { 
      showNum: 0,
      images: [
       '../resource/images/arrow.jpg',
      '../resource/images/arrow.jpg',
        '../resource/images/arrow.jpg'
      ],
      indicatorDots: true,
      vertical: false,
      autoplay: true,
      interval: 3000,
      duration: 1200
    ,

    // item
    index_index_items_tmpl: {
      items: [
        { image: '../resource/images/arrow.jpg'},
        { image: '../resource/images/arrow.jpg'},
        { image: '../resource/images/arrow.jpg'}
      ]
    },
    //分页所属属性
    totalPage: 1,
    currentPage: 1,
    videoList: [],
    serverUrl: '',
    //跑马灯
    
  },

  onLoad: function() {
    var me = this;
    var currentPage = me.data.currentPage;
    me.getAllVideo(currentPage);   
    me.getHotVideo();
    //me.paomad();
  },
  
  getAllVideo: function (currentPage) {
    var me = this;
    var serverUrl = app.serverUrl;
    wx.showLoading({
      title: '亲,视频加载中',
    });
    wx.request({
      url: serverUrl + '/video/queryAllVideo?currentPage=' + currentPage,
      method: "POST",
      success: function (res) {
        wx.hideLoading();
    //    wx.hideNavigationBarLoading();
     //   console.log(res.data);
        //判断当前页是否是第一页
        if (currentPage === 1) {
          me.setData({
            videoList: []
          });
        }
        var videoList = res.data.data.rows;
        var newVideoList = me.data.videoList;
        me.setData({
          videoList: videoList,
          currentPage: currentPage,
          totalPage: res.data.data.totalPage,
          serverUrl: serverUrl
        });
      }
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
        url: '../index/index',
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
  },
  getHotVideo: function () {
    var me = this;
    var serverUrl = app.serverUrl;
    // wx.showLoading({
    //   title: '亲,视频加载中',
    // });
    wx.request({
      url: serverUrl + '/video/queryHotVideos',
      method: "POST",
      success: function (res) {
      //  wx.hideLoading();
      //  wx.hideNavigationBarLoading();
        console.log(res.data);
        var videoList = res.data.data;
        me.setData({
          hotvideoList: videoList
        });
      }
    })
  },
  nextVideoList: function () {
    var me = this;
    var currentPage = me.data.currentPage;
    var totalPage = me.data.totalPage;
    if (currentPage === totalPage) {
      me.setData({
        currentPage: 1
      });
      me.getAllVideo(1); 
    }else{
      var nextPage = currentPage + 1;
      me.getAllVideo(nextPage);   
    } 
  },
  showVideoDetail: function (e) {
    var me = this;
    var videoList = me.data.videoList;
    var index = e.target.dataset.arrindex;
    var videoDetail = JSON.stringify(videoList[index]);
    wx.redirectTo({
      url: '../videodetail/videodetail?videoDetail=' + videoDetail,
    })
  },
  showHotVideoDetail: function (e) {
    var me = this;
    var videoList = me.data.hotvideoList;
    var index = e.target.dataset.arrindex;
    var videoDetail = JSON.stringify(videoList[index]);
    wx.redirectTo({
      url: '../videodetail/videodetail?videoDetail=' + videoDetail,
    })
  },
  
 
})