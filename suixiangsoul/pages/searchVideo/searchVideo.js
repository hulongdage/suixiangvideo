// 1 导入js文件
var WxSearch = require('../../wxSearchView/wxSearchView.js');

const app = getApp()

Page({
  data: {
  },

  onLoad: function () {
        //初始化搜索栏
        var that = this;
        //查询热搜词
        var serverUrl = app.serverUrl;
        wx.request({
          url: serverUrl + '/video/hotWord',
          method: 'POST',
          header: {
            'content-type': 'application/json'
          },
          success:function(res){
             console.log(res);
             var hotWordList = res.data.data;
            WxSearch.init(
              that,  // 本页面一个引用
              hotWordList, // 热点搜索推荐，[]表示不使用
              hotWordList,// 搜索匹配，[]表示不使用
              that.mySearchFunction, // 提供一个搜索回调函数
              that.myGobackFunction //提供一个返回回调函数
            );

          }
        })
      },

  // 3 转发函数，固定部分，直接拷贝即可
  wxSearchInput: WxSearch.wxSearchInput,  // 输入变化时的操作
  wxSearchKeyTap: WxSearch.wxSearchKeyTap,  // 点击提示或者关键字、历史记录时的操作
  wxSearchDeleteAll: WxSearch.wxSearchDeleteAll, // 删除所有的历史记录
  wxSearchConfirm: WxSearch.wxSearchConfirm,  // 搜索函数
  wxSearchClear: WxSearch.wxSearchClear,  // 清空函数

  // 4 搜索回调函数  
  mySearchFunction: function (value) {
    // do your job here
    // 示例：跳转
    wx.redirectTo({
      url: '../searchResultPage/searchResultPage?isSaveRecord=1&searchWord=' + value
    })
  },

  // 5 返回回调函数
  myGobackFunction: function () {
    // do your job here
    // 示例：返回
    wx.redirectTo({
      url: '../index/index'
    })
  }
  
    })

  
  


