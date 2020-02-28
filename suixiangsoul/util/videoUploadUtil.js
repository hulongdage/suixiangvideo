function uploadVideo() {
  wx.chooseVideo({
    sourceType: ['album'],
    success: function(res) {
      console.log(res);
      var duration = res.duration;
      var tmpHeight = res.height;
      var tmpWidth = res.width;
      var tmpVideoUrl = res.tempFilePath;
      var tmpCoverUrl = res.thumbTempFilePath;

      if (duration > 20) {
        wx.showToast({
          title: '视频长度不能超过20秒...',
          icon: "none",
          duration: 2500
        })
      } else if (duration < 10) {
        wx.showToast({
          title: '视频长度太短，请上传超过10秒的视频...',
          icon: "none",
          duration: 2500
        })
      } else {
        wx.navigateTo({
          url: '../bgm/bgm?duration=' + duration +
            "&tmpHeight=" + tmpHeight +
            "&tmpWidth=" + tmpWidth +
            "&tmpVideoUrl=" + tmpVideoUrl +
            "&tmpCoverUrl=" + tmpCoverUrl,
        })
      }

    }
  })
}
module.exports={
  uploadVideo: uploadVideo
}