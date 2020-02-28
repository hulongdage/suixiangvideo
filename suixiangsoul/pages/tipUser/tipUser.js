const app = getApp()

Page({
    data: {
        reportOption: "请选择原因",
        reportReasonArray: app.reportReasonArray,
        publishUserId:"",
        videoId:""
    },

    onLoad:function(params) {
      var me = this;

      var videoId = params.reportvisionid;
      var publishUserId = params.reportuserid;

      me.setData({
        publishUserId: publishUserId,
        videoId: videoId
      });
    },

    reportOptionChange:function(e) {
     var that = this;
     var index = e.detail.value;
      var reportOption = app.reportReasonArray[index];
     that.setData({
       reportOption: reportOption
     });
    },

    submitReportForm:function(e) {
      var me = this;

      var reasonIndex = e.detail.value.reasonIndex;
      var reasonContent = e.detail.value.reasonContent;

      var user = app.getGlobalUserInfo();
      var currentUserId = user.id;

      if (reasonIndex == null || reasonIndex == '' || reasonIndex == undefined) {
        wx.showToast({
          title: '选择举报理由',
          icon: "none"
        })
        return;
      }

      var serverUrl = app.serverUrl;
      wx.request({
        url: serverUrl + '/user/tipUser',
        method: 'POST',
        data: {
          reportuserid: me.data.publishUserId,
          reportvisionid: me.data.videoId,
          reporttitle: app.reportReasonArray[reasonIndex],
          reportcontent:reasonContent,
          userid: currentUserId
        },
        header: {
          'content-type': 'application/json', // 默认值
          'userId': user.id,
          'usertoken': user.usertoken
        },
        success:function(res) {
          wx.showToast({
            title: res.data.msg,
            duration: 2000,
            icon: 'none',
            success: function() {
              wx.navigateBack();
            }
          })
        }
      })
    } 
})
