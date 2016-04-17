#TextToSpeech的使用
##官方Api地址：[TextToSpeech](http://developer.android.com/reference/android/speech/tts/TextToSpeech.html)
###使用很简单，把官方文档翻译一边就行
###1.使用注意事项：
####作用：将文字快速转化为语音进行播放或者保存为音频文件
####`TextToSpeech`必须再被实例化之后才能使用.实现`TextToSpeech.OnInitListener`方法来获取实例化结果的提醒。当你已经使用完`TextToSpeech`实例之后, 应该调用` shutdown()`方法来释放`TextToSpeech`所使用的本地资源
###2.内嵌的类
| 类型| 名称|功能|
|--|--|
|`class`|`TextToSpeech.Engine`|控制文字转化语音的常亮或者参数名|
|`class`|`TextToSpeech.EngineInfo`|已安装的语音引擎的信息|
|`interface`|`TextToSpeech.OnInitListener`|定义了语音引擎初始化结果的回调接口|
|`interface`|`TextToSpeech.OnUtteranceCompletedListener`|API level 18被弃用 . 使用`UtteranceProgressListener`替代|  
###3.常量：
|类型|名称|功能|
|--|--|--|
|`String`|`	ACTION_TTS_QUEUE_PROCESSING_COMPLETED`|广播事件，表示`TextToSpeech`转化器已经转化未所有处于语音队列的文本|
|`int`|`ERROR`|表示一般的操作失败|
|`int`|	`ERROR_INVALID_REQUEST`|	表示由于无效请求导致的失败|
|`int`|	`ERROR_NETWORK`|	表示由于网络连接问题导致的失败|
|`int`|	`ERROR_NETWORK_TIMEOUT`|	表示由于网络连接超时引起的失败|
|`int`|	`ERROR_NOT_INSTALLED_YET`|	表示由于未完成的语音数据下载导致的错误|
|`int`|`	ERROR_OUTPUT`|	表示输出产生的失败|
|`int`	|`ERROR_SERVICE	`|表示由于TTS服务产生的失败|
|`int`|	`ERROR_SYNTHESIS`|	表示由于引擎的输入转化的输入内容引起的失败|
|`int	|`LANG_AVAILABLE`|	表示本地语言可用，但不是方言或者引申语言（不知道对不对）|
|`int`|	`LANG_COUNTRY_AVAILABLE`	|表示本地语音或者方言可用，引申语音不可用|
|`int`|`LANG_COUNTRY_VAR_AVAILABLE`	|表示本地语音可用|
|`int`	|`LANG_MISSING_DATA`	|语言包丢失|
|`int`|	`LANG_NOT_SUPPORTED`	|表示语音不支持|
|`int`	|`QUEUE_ADD`	|新的转化任务添加到队列后面|
|`int`|	`QUEUE_FLUSH`|新的任务替代以前的任务，直接中断以前的任务|
|`int`|	`STOPPED`|	表示由代理要求的停止|
|`int`|	`SUCCESS`|	操作成功|

##4：构造方法：
```
//使用默认的引擎
TextToSpeech(Context context, TextToSpeech.OnInitListener listener)
//使用指定的引擎
TextToSpeech(Context context, TextToSpeech.OnInitListener listener, String engine)

```
##5.

|返回类型|名称|功能|
|--|--|--|
|`int`|	`addEarcon(String earcon, File file)`|添加文字和本地文件的映射|
|`int`	|`addEarcon(String earcon, String packagename, int resourceId)`|添加指定包下的文字和本地文件的映射|
|`int`	|`addSpeech(String text, String packagename, int resourceId)`|添加本地资源和文字的映射|
|`int`	|`addSpeech(String text, String filename)`|添加文字和本地文件的映射|
|`int`|	`addSpeech(CharSequence text, File file)`|添加字符串和本地文件的映射|
|`int`	|`addSpeech(CharSequence text, String packagename, int resourceId)`|添加指定包下的文字和本地文件的映射|
|`boolean`	|`areDefaultsEnforced()`|检查是否用户的设置应该覆盖应用的设置|
|`Set<Locale>`|	`getAvailableLanguages()`|获取可行的语言|
|`String`|	`getDefaultEngine()`|获取默认的引擎|
|`Voice`	|`getDefaultVoice()`|获取默认使用的声音|
|`List<TextToSpeech.EngineInfo>`|	`getEngines()`|返回已安装的TTS引擎|
|`static int`	|`getMaxSpeechInputLength()`|获取要转换文字的长度限制|
|`Voice`	|`getVoice()`|返回一个当前正在使用的声音实例|
|`Set<Voice>`|	`getVoices()`|询问引擎可用的声音|
|`int`	|`isLanguageAvailable(Locale loc)`|检查指定语音是否支持|
|boolean`	|`isSpeaking()`|检查是否引擎正在播放|
|`int`	|`playEarcon(String earcon, int queueMode, Bundle params, String utteranceId)`|使用指定方式和参数播放耳标|
|`int`	|`playSilentUtterance(long durationInMs, int queueMode, String utteranceId)`|指定时间使指定的事物静音|
|`int`	|`setAudioAttributes(AudioAttributes audioAttributes)`|设置播放和存文件的音频属性|
|`int`	|`setLanguage(Locale loc)`|设置文字转语音的语言|
|`int`|	setOnUtteranceProgressListener(UtteranceProgressListener listener)`|设置监听播放进度的回调|
|`int`	|`setPitch(float pitch)`|设置语音的声高|
|`int`	|`setSpeechRate(float speechRate)`|设置播放速率|
|`int`	|`setVoice(Voice voice)`|设置文字语音转化的声音|
|`void	`|`shutdown()`|释放引擎使用的资源|
|`int`	|`speak(CharSequence text, int queueMode, Bundle params, String utteranceId)`|使用给定的队列方法和语音参数来播放文字|
|`int`	|`stop()`|中断当前任务，不管是播放还是转化文件，抛弃队列内的其他任务|
|`int`|`synthesizeToFile(CharSequence text, Bundle params, File file, String utteranceId)`|使用传入的参数转化给定的文字到文件|


###下面是示例：从`EditText`读取文字病朗读：
```

public class MainActivity extends AppCompatActivity {
    private EditText mEt;
    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BrioalUtil.init(this);
        setContentView(R.layout.activity_main);
        mEt = (EditText) findViewById(R.id.main_et);
        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    //初始化成功
                } else {
                    Toast.makeText(MainActivity.this, "初始化失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void speak(View view) {
        String content = mEt.getText().toString();
        if (content.isEmpty()) {
            //
            textToSpeech.speak("你是傻逼吗", TextToSpeech.QUEUE_ADD, null);
        } else {
            //
            textToSpeech.speak(content, TextToSpeech.QUEUE_ADD, null);

        }
    }
}
```


