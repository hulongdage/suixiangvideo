//index.js
//获取应用实例
var app = getApp()
Page( {
  data: { 
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
    searchContent: "",

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
  },

  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo( {
      url: '../logs/logs'
    })
  },

  onLoad: function (params) {
    var me = this;
    var searchContent = params.searchWord;
    var isSaveRecord = params.isSaveRecord;
    if (isSaveRecord == null || isSaveRecord == '' || isSaveRecord == undefined) {
      isSaveRecord = 0;
    }

    me.setData({
      searchContent: searchContent
    });

    // 获取当前的分页数
    var currentPage = me.data.currentPage;
    me.getAllVideo(currentPage, isSaveRecord);
  },
  getAllVideo: function (currentPage, isSaveRecord) {
    var me = this;
    var serverUrl = app.serverUrl;
    wx.showLoading({
      title: '亲,视频加载中',
    });
    var searchContent = me.data.searchContent;
    wx.request({
      url: serverUrl + '/video/searchVideo?currentPage=' + currentPage + "&isSavedRecords=" + isSaveRecord,
      method: "POST",
      data: {
        visiondesc: searchContent
      },
      success: function (res) {
        wx.hideLoading();
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
  nextVideoList: function () {
    var me = this;
    var currentPage = me.data.currentPage;
    var totalPage = me.data.totalPage;
    if (currentPage === totalPage) {
      me.setData({
        currentPage: 1
      });
      me.getAllVideo(1,0); 
    }else{
      var nextPage = currentPage + 1;
      me.getAllVideo(nextPage,0);   
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
  calling: function () {
    wx.makePhoneCall({
      phoneNumber: '13923638663',
      success: function () {
        console.log("拨打电话成功！")
      },
      fail: function () {
        console.log("拨打电话失败！")
      }
    })
  },
  //http://lbs.qq.com/tool/getpoint/ 坐标拾取器
  click: function (e) {
    wx.openLocation({
      latitude: 22.793340,
      longitude: 114.479970,
      scale: 18,
      name: '惠州市惠阳源记汽车音响改装中心',
      address: '惠州市惠阳区谈水大埔卢屋山桥头'
    })
  },  
  onShareAppMessage: function () {
    return {
      title: '惠州源记丹拿汽车音响改装',
      desc: '惠州专业汽车音响改装，汽车维修!',
      path: '/pages/index/index'
    }
  },
})