# kwebview_shell演示DEMO
kwebview接入步骤：
1，将kwebview.aar包含到工程中。
2，在app build.gradle android加入 
    aaptOptions {
        noCompress "pdf"
    }
    
kwebview的接口跟Android 5.0的Webview接口保持一致，但包名不一样。 （android.webkit.xxx -> com.kingsoft.kwebview.xxx)。
目前还有很多bug，仅作学习，请勿用在商业产品中。
