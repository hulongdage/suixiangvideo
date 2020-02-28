const app = getApp()

Page({
  data: {
  },
  onLoad: function(params){
    var redirectUrl = params.redirectUrl;
    if (redirectUrl != null && redirectUrl != undefined && redirectUrl != '') {
      //用正则表达式将url中的#和@符号替换
      redirectUrl = redirectUrl.replace(/#/g, "?");
      redirectUrl = redirectUrl.replace(/@/g, "=");
      this.redirectUrl = redirectUrl;
    }  
  },
  // 登录  
  doLogin: function (e) {
    var that = this;
    var formObject = e.detail.value;
    var username = formObject.username;
    var password = formObject.password;
    // 简单验证
    if (username.length == 0 || password.length == 0) {
      wx.showToast({
        title: '用户名或密码不能为空',
        icon: 'none',
        duration: 3000
      })
    } else {
      var serverUrl = app.serverUrl;
      wx.showLoading({
        title: '请稍候...',
      })
      // 调用后端
      wx.request({
        url: serverUrl + '/login',
        method: "POST",
        data: {
          username: username,
          password: password
        },
        header: {
          contentType: "application/json"
        },
        success: function (res) {
          console.log(res.data);
          wx.hideLoading();
          if (res.data.status == 200) {
            wx.showToast({
              title: '登录成功',
              icon: 'success',
              duration: 2000
            });
            // app.userInfo = res.data.data;
            app.setGlobalUserInfo(res.data.data); //本地缓存     
            var redirectUrl = that.redirectUrl;
             // 登录成功跳转
            if (redirectUrl != null && redirectUrl != undefined && redirectUrl != ''){
              wx.redirectTo({
                url: redirectUrl
              })
            }else{
              wx.reLaunch({
                url: '../index/index',
              })
            }
           
            
          } else if (res.data.status == 500) {
            // 失败弹出框
            wx.showToast({
              title: res.data.msg,
              icon: 'none',
              duration: 3000
            })
          }
        }
      })
    }
  },

  toRegist:function() {
    wx.redirectTo({
      url: '../register/register',
    })
  },
  toIndex: function () {
    wx.reLaunch({
      url: '../index/index',
    })
  }
})