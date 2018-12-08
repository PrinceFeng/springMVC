    // 使用说明：
    // 1. load事件监听里调用imageViewer.init(opt), opt参数如下：
    // {
    //   imgListId：'', 包裹所有图片的容器Id
    //   viewerId: '', 包裹查看器的容器id
    //   zindex: 0, css层级关系，不写默认9999
    // }
    // 2. 需要查看的每张图片需设置key属性，属性值为图片列表中唯一的一个数字标识
var imageViewer = {
  init(opt) {
    var opt = opt || {},
        imgListId = opt.imgListId || "imageList",
        viewerId = opt.viewerId || "imageViewer",
        viewer = '';
    imageViewer.rejectCss({
      zindex: opt.zindex
    });
    document.getElementById(viewerId).innerHTML =
      '<div class="imageViwer" style="opacity:0;display:none">\
        <div class="imageViwer_bg"></div>\
        <span class="imageViwer_btn_pre"><i class="iconfont icon-houtui"></i></span>\
        <span class="imageViwer_btn_next"><i class="iconfont icon-qianjin"></i></span>\
        <span class="imageViwer_btn_close"><i class="iconfont icon-guanbi"></i></span>\
        <img src="" alt="" key="" class="imageViwer_container" />\
      </div>';
    viewer = document.getElementById(viewerId).getElementsByClassName("imageViwer")[0];
    document.getElementById(imgListId).addEventListener("click", function (e) {
      if (e.target.tagName.toLowerCase() === "img") {
        var imageSrc = e.target.getAttribute('src'),
          imageKey = e.target.getAttribute('key');
        viewer.getElementsByTagName("img")[0].setAttribute("src", imageSrc);
        viewer.getElementsByTagName("img")[0].setAttribute("key", imageKey);
        viewer.style.display = "block";
        window.setTimeout(function () {
          viewer.style.opacity = "1";
        },0)
      }
    }, false);
    var closeViwerHandler = function (e) {
      viewer.getElementsByTagName("img")[0].setAttribute("src", '');
      viewer.getElementsByTagName("img")[0].setAttribute("key", '');
      viewer.style.display = "none";
      viewer.style.opacity = "0";
    };
    document.getElementsByClassName("imageViwer_btn_close")[0].addEventListener("click", closeViwerHandler, false);
    document.getElementsByClassName("imageViwer_bg")[0].addEventListener("click", closeViwerHandler, false);
    var paginationHandler = function (action) {
      return function (e) {
        var actionKey = 0;
        var currentImg = e.target.parentNode.parentNode.getElementsByTagName("img")[0];
        if (action.toLowerCase() === "pre") {
          actionKey = parseInt(currentImg.getAttribute("key")) - 1;
        } else if (action.toLowerCase() === "next") {
          actionKey = parseInt(currentImg.getAttribute("key")) + 1;
        };
        targetOriginImg = document.getElementById(imgListId).querySelector("#" + imgListId + " img[key='" + actionKey + "']");
        if (targetOriginImg) {
          currentImg.setAttribute("src", targetOriginImg.getAttribute("src"));
          currentImg.setAttribute("key", targetOriginImg.getAttribute("key"));
        } else {
          return false
        };
      };
    }
    document.getElementsByClassName("imageViwer_btn_pre")[0].addEventListener("click", paginationHandler("pre"), false);
    document.getElementsByClassName("imageViwer_btn_next")[0].addEventListener("click", paginationHandler("next"), false);
  },
  rejectCss(opt){
    var zindex = parseInt(opt.zindex) || 9999;
    var css = '.imageViwer,.imageViwer *{transition:all .3s ease-in;}\
    .imageViwer{ position: fixed; top: 0; bottom: 0; left: 0; right: 0; z-index: '+zindex+';}\
    \
    .imageViwer_bg{ width: 100%; height: 100%; opacity: .5; background-color: #333;}\
    img.imageViwer_container { position: absolute; z-index: '+ (zindex + 1) +'; max-width: 100%; max-height: 100%; top: 50%; left: 50%; transform: translate(-50%, -50%);} \
	.imageViwer_btn_close{ z-index: '+(zindex+2)+';font-size: 40px; position: absolute; top: 20px; right: 50px; color: #ffffff; cursor: pointer;}\
    .imageViwer_btn_pre,.imageViwer_btn_next{ z-index: '+(zindex+2)+'; font-size: 40px; font-weight: bold; position: absolute; color: #ffffff; cursor: pointer; top: 45%;}\
	.imageViwer_btn_close i{font-size: 40px;}\
    .imageViwer_btn_pre{ left: 50px }\
	.imageViwer_btn_pre i,.imageViwer_btn_next i{ font-size: 40px;}\
    .imageViwer_btn_next{ right: 50px; }';
    var style = document.createElement('style');
    var head = document.head || document.getElementsByTagName('head')[0];
    style.innerHTML = css;
    head.appendChild(style);
  }
};