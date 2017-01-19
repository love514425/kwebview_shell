kwebview接入步骤：
- 1，将kwebview.aar包含到工程中。
- 2，在app build.gradle android 中加入 
    aaptOptions {
       noCompress "dat", "bin", "pak"
    }
    
kwebview的接口跟Android 5.0的webview接口保持一致，仅包名不一样。 （android.webkit.xxx -> com.kingsoft.kwebview.xxx)。

目前还有很多bug，仅作学习，如果应用在实际产品中造成的一切问题本人概不负责。
