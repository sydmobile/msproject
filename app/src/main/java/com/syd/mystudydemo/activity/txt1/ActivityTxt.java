package com.syd.mystudydemo.activity.txt1;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.syd.mystudydemo.R;
import com.syd.mystudydemo.activity.base.BaseActivity;

/**
 * Created by sydMobile on 2018/5/14.
 * 文档页面
 */
public class ActivityTxt extends BaseActivity {
    private TextView textView;
    private TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(android.R.layout.list_content);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }

    @Override
    protected void onStart() {
        super.onStart();
        textView1 = findViewById(R.id.bt_secondprocess);
        textView = findViewById(R.id.tv);
        getWindow().getDecorView().getId();
        getWindow().getDecorView().getWidth();
        //TODO InputManager
    /*
    InputMethodManager类的介绍
    [inputMethodManager]()
    先来看看API对InputMethodManager类的介绍：
    以整体输入法架构（IMF(input method framework)）为架构
    的中央系统API，关系着应用程序和当前输入方法之间的交互。
    用 getSystemService(Context.INPUT_METHOD_SERVICE);来获取
    它的实例
    关于这个类有4个主要的主题：
    1.Architecture Overview
    2.Applications
    3.Input Methods
    4.Security

    Architecture Overview
    在输入法架构中有三个主要的部分。
    1.这个类所表达的输入法管理器是管理所有其他部分之间交互的系统中心点。
    它是存在在每个Context中的API，并与管理所有进程间交互的全局系统服务
    进行通信。

    2.输入法（IME）实现了一个特定的交互模型，允许用户来生成文本。系统会
    绑定到当前正在使用的输入法，使其被创建并运行，并且决定它何时隐藏和
    显示其UI。一次只可以运行一个IME

    3.多个客户端应用程序使用输入法管理器进行仲裁，用来获取输入焦点并控制
    IME的状态。一次只有一个这样客户端活动（与IME一起工作）

    Applications

    在大多数情况下，使用标准的TextView或者其子类的应用程序对于使用软输入方
    法工作的很少，你需要知道的主要事情是：

    在可编辑的文本视图中正确的设置inputType，以便输入方法具有足够的上下文来
    帮助用户输入文本。在输入法显示的时候处理丢失的屏幕空间，理想情况下，应用
    程序应该处理其窗口被调整的较小，但是如果需要，它可以依靠系统执行窗口的
    平移。你应该在你的Activity上设置windowSoftInputMode属性(在清单文件中设置
    关于这个属性，在下面会单独列出)，或者在你创建
    的窗口上设置相应的值用来帮助系统确定是平移还是调整大小（它会尝试自动确定，但
    可能会出现错误）。
    你还可以使用windowSoftInputMode属性来控制窗口的首选软输入状态（打开、关闭等）
    通过API可以实现更细致的控制，直接与IMF及IME进行交互-显示或者隐藏输入区域，让
    用户选择输入方法等。

    对于编写自己的文本编辑器的少数人员来说，需要实现
    InputConnection onCreateInputConnection (EditorInfo outAttrs)来返回你自己
    的InputConnection接口的新的实例，从而运行IME与您的编辑器进行交互。

    Input Methods
    输入法（IME）作为服务实现，通常从InputMethodService派生。它必须提供核心的
    InputMethod接口，虽然这通常由InputMethodService处理，实现着只需要在那里处理
    更高级别的API。
    有关实现IME的更多信息，参阅InputMethodService类（这里我们主要讲的是管理应用程序
    和输入法的InputMethodManager，对于InputMethodService不细说，这是关于输入法程序
    的）

    Security

    输入法有很多安全问题，因为它们本质上有完全驱动用户界面和监视用户输入的所有内容
    的自由。Android的输入法框架也允许任意的第三方输入法，所以必须小心限制它们的选择
    和交互。
    下面是一些关于IMF安全架构的一些关键点

    只有系统可以通过BIND_INPUT_METHOD权限来直接访问IME的InputMethod接口。这在系统中
    通过不绑定到不需要此权限的输入法服务来实施，因此系统可以保证其他不受信任的客户端正在
    访问其控制之外的当前输入法。

    在输入法框架（IMF）中可能会有很多客户进程，但是一次只能有一个活动的，不活跃的不能
    通过下面描述的机制与IMF的关键部分互动。

    输入方法的客户端只能访问其InputMethodSession接口。此接口的一个实例为每个客户端创建，
    并且只有来自与活动的客户端关联的会话的调用将被当前的IME处理。这是由AbstractInputMethod
    Service为普通的IME强制执行的，但必须由定制原始InputMethodSession实现的IME明确处理。

    只有活跃的客户端的 InputConnection 才会接受操作，IMF告诉每个客户端进程是否是活跃的，并且
    该框架会强制在非活动状态下调用当前的InputConnection将被忽略。这样就确保了当前的IME仅能够
    向用户所看到的用户界面提供事件和文本编辑。

     当屏幕关闭的时候，IME永远不会与（InputConnection）进行交互。这是通过屏幕关闭时使所有
     客户端处于非活动状态来实施的，并且防止了坏的IME在用户无法意识到其行为时驱动用户界面。

     客户端应用程序可以要求系统让用户选择新的IME，但是不能用编程的方式自行切换。这样可以避免
     恶意应用程序将用户选择的切换到自己的IME，当用户切换到另一个应用程序的时候，IME仍然会
     运行。另一方面，IME允许以编程的方式将系统切换到另一个IME，因为它已经有了完全的控制权对于
     用户输入来说。

     用户必须在设置之前明确启用新的IME，然后才能切换到该设置，以确认系统是否知道它并且希望其可
     供使用。

     一些对键盘的操作

     1.显示输入法键盘
     显示输入法键盘的方法有：
     InputMethodManager  imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

     imm.showSoftInput(View view,int flags);

     imm.showSoftInput(View view,int flags,ResultReceiver resultReceiver);

     boolean showSoftInput(View view,int flags)

     分别介绍一下：

     图片：showSoftInput(12)
     关于这个方法很简单，作用就是显示软键盘。
     参数介绍：
     view:当前焦点所在的view，这个view会接受键盘的输入

     view也不是所有的view都是适合的，有限制，view必须是EditText以及它的子类，其他类型的View
     ，比如Button、TextView等等这些控件是不起作用的。
     参数中的view必须是可以获取焦点的，并且view已经获得了焦点，这个方法才会起作用，如果传出的
     view当前没有获得焦点，这个方法是不会起作用的。view必须是可见的。
     flags:提供附件的操作标志，可以取0、SHOW_IMPLICIT、

     其他的限制条件，当前布局必须已经完成加载了，如果还未绘制完成的话，是不起作用的，比如我们有很多情况
     下需要进入一个新的页面就显示键盘，有很多


     图片：showSoftInput(123)

     明确要求当前输入法的软输入区域在需要时显示给用户。 如果用户与您的视图进行交互，
     并表达他们希望开始对其执行输入，请调用此函数。（注意只有当你穿入的view获得焦点的时候
     ，调用这个方法才会弹出键盘。）
     警告：传递给此方法的{@link ResultReceiver}实例可能是一个长寿命的对象，因为它可能
     不会被垃圾收集，直到所有相应的{@link ResultReceiver}对象传输到 不同的进程会被垃圾收集。
     遵循一般模式来避免Android中的内存泄漏。
     考虑使用{@link java.lang.ref.WeakReference}，以便{@link android.app.Activity}和{@link Context}
     等应用程序逻辑对象可以进行垃圾收集，无论{@link ResultReceiver}。

     @param resultReceiver如果非null，则IME会在处理完请求后告诉您它做了什么。 您收到的结果代码可能是
     {@link #RESULT_UNCHANGED_SHOWN}，
    {@link #RESULT_UNCHANGED_HIDDEN}，{@link #RESULT_SHOWN}或
    {@link #RESULT_HIDDEN}。

    介绍一下这个几个参数：

    RESULT_UNCHANGED_SHOWN = 0 ;
    showSoftInput(View,int,ResultReceiver)和hideSoftInputFromWindow(IBinder,int,ResultReceiver)
    中的ResultReceiver的结果代码标志，表示输入键盘的状态没有改变，仍然保持显示状态。也就是说在你调用
    这个方法之前输入键盘就处于显示状态了，调完之后仍然是显示状态。

    RESULT_UNCHANGED_HIDDEN = 1;
    showSoftInput(View,int,ResultReceiver)和hideSoftInputFromWindow(IBinder,int,ResultReceiver)
    中的ResultReceiver的结果代码标志，表示输入键盘的状态没有改变，仍然保持隐藏状态。

    RESULT_SHOWN = 2
    showSoftInput(View,int,ResultReceiver)和hideSoftInputFromWindow(IBinder,int,ResultReceiver)
    中的ResultReceiver的结果代码标志，表示输入键盘的状态发生了改变，切换到了显示的状态


    RESUlT_HIDDEN = 3
    showSoftInput(View,int,ResultReceiver)和hideSoftInputFromWindow(IBinder,int,ResultReceiver)
    中ResultReceiver的结果代码标志，表示输入键盘从显示切换到隐藏时的状态

    其中关于ResultReceiver简单的说一下，

    ResultReceiver

    用于接收某人的回调结果的通用接口。 通过创建子类并实现{@link #onReceiveResult}来使用它，
    然后您可以将其传递给其他人并通过IPC发送，并通过{@link #send}接收它们提供的结果。
    然后你可以通过send(int Bundle)这个方法在进程间（IPC）进行传递信息。

    用在showSoftInput(View,int,ResultReceiver)方法中就是，

    自己定义一个类继承ResultReceiver，重写里面的 onReceiveResult方法。
    onReceiverResult这个方法就是回调方法，用于处理其他进程传过来的数据

    比如：

    public class MyResultReceiver  extends ResultReceiver{

        public MyResultReceiver(Handler handler){

            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode,Bundle resultData){
            super.onReceiveResult(resultCode,resultData);
            //根据返回结果处理相应的逻辑
            // resultCode就会根据键盘的状态出现上面介绍的那几个值
        }

    }

    介绍一下 flag，也就是showSoftInput()方法的第二个参数

    按照官方文档，这个参数的值可以取，0，SHOW_IMPLICIT
    0的话就表示什么含义都没有。
    SHOW_IMPLICIT:表示这是隐式的请求来显示输入窗口，而不是用户的直接请求结果。在这种情况下
    可能不会显示窗口

    SHOW_FORCED ：表示用户强制输入方法处于打开状态（例如通过长按菜单），所以只有在明确关闭（
    这个时候通过调用关闭输入方法的时候的参数决定）的情况下才能关闭。

    这样看起来可以会一头雾水，云里雾里的，不要紧，其实这个地方的这个参数只是一个标记，和关闭键盘
    方法的参数一一对应，在这里其实你只要随便写一个整数都可以打开键盘。下面说关闭键盘的方法就都清楚了。






    关于showSoftInput(View,int)起作用的条件，
    参数中的view必须是EditText以及他的子类，必须是获得焦点的，可见的，只有满足这些条件才起作用。
    另外必须在当前布局已经加载完成后showSoftInput()才起作用（其他的和键盘有关的方法都一样）。
    所以如果在onCreate中直接调用的话，很可能是不起作用的，这个时候开启一个延迟执行就可以了。

    比如：
    getWindow().getDecorView().postDelayed(new Runnable(){

        @Override
        public void run(){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            if(imm != null){
                //请求获取焦点
                view.requestFocus();
                imm.showSoftInput(view,0);
            }


        }

    },100);



    关于显示软键盘还有一个方法
    showSoftInputFromInputMethod(IBinder token, int flags)
    图片：showSoftInputFromInputMethod中
    关于这个方法，其介绍文档说的很清楚了

    显示输入法的软输入区域，以便用户看到输入法窗口并可以与之交互。 这只能从当前活动的输入方法调用，
    由给定的令牌验证。

    只能从当前活动的输入方法调用，从它的名字也可以看得出来，FromInputMethod  所以这个方法我们再按照调用
    showSoftInput()方法一样调用是不起作用的，这个方法的调用位置是有限制的。





    写一个Activity用于启动IntentService

    */


    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onRestart() {
        super.onRestart();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Service.INPUT_METHOD_SERVICE);
                if (inputMethodManager != null) {

                    inputMethodManager.showSoftInput(textView, 0);
                }


            }
        });


        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //TODO Hierarchy Viewer
    /*
    翻译自 https://developer.android.com/studio/profile/hierarchy-viewer.html
    官方文档
    审阅你的布局通过Hierarchy Viewer
    Hierarchy Viewer 是一Android Device Monitor里面的一个工具，它可以帮助你测量布局层次
    结构中每个视图的布局速度。它可以帮助你找到由视图层次结构造成的性能问题。

    注意：Hierarchy Viewer 不再被继续开发，要在运行时查看视图层次结构的性能，你应该使用
    在Android Studio中的Layout Inspector。但是Layout Inspector目前不能查看布局的内容信息。

    这篇文章提供了Hierarchy Viewer的介绍以及用于分析布局的例子。如果你想要
    查看UI中每个像素的布局，并将其与你的设计模式相比较，用 Pixel Perfect 工具

    Get set Up  设置

    如果您使用的是Android模拟器，则可以跳过本节。 否则，您需要按照以下步骤设置您的设备。

    注意你的Android设备系统必须是4.1或者更高。

    1. 打开开发者选项
    2. 在开发机器上设置环境变量ANDROID_H_V_PROTO = ddm。该变量告诉Hierarchy Viewer使用ddm协议连接到设备
    ，该协议与 DDMS 协议相同。 需要注意的是，连接到设备的主机上只能有一个进程，
    因此您必须终止任何其他DDMS会话才能运行Hierarchy Viewer。







     */


        textView1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    // TODO Measure 过程
    /*

    传递尺寸的 2 个类

    ViewGroup.LayoutParams 类
    MeasureSpecs 类

    ViewGroup.LayoutParams
    布局参数类
    ViewGroup 的子类（RelativeLayout、LinearLayout、等等很多 F:\MyFile\myproject\myblog\trunk\pic\measure）

    作用：指定视图 View 的高度和宽度等布局参数。

    MeasureSpec
    简介：测量规格类。决定一个视图 View 的大小，每一个 MeasureSpec 代表一组宽度 & 高度。

    MeasureSpec = mode（测量模式）+ 测量大小（size） 组成

    UNSPECIFIED   父视图不约束子视图 View   系统内部应用（如 ListView、ScrollView）  一般自定义 view 中，用不到

    EXACTLY     父视图为子视图指定了一个确切的尺寸。子视图大小必须在该指定尺寸内。



     */


    @Override
    protected void onResume() {
        super.onResume();


    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

        /*
        EditText的一个属性（imeOptions）

        首先说明这个词的意思：imeOptions(ime其实是 Input Method Editor Options)翻译过来就是
        输入方法编辑选择。
        我们在Android官方文档查看这个属性
        ![]()



        参考：http://www.jianshu.com/p/060b5f68da79

        ![结构图,没有画]()
        Activity
        PhoneWindow
        DecorView
        TitleView
        ContentView
        DecorView是一个应用窗口的跟容器，本质上是FrameLayout,我们在API中可以
        看到DecorView是继承自FrameLayout的。
        ![DecorView]()
        DecorView在API里面是隐藏的，所以直接查看FrameLayout的子类是找不到的
        DecorView有一个唯一的View，是一个垂直的LinearLayout，包含两个元素
        一个是TitleView（作为ActionBar的容器存在），另一个就是ContentView
        （我们显示的内容）。ContentView是一个FrameLayout，我们平常使用setContentView
        就是这设置它的子View。每一Activity都对应着一个Window（Window是抽象类，
        其实是它的实现类PhoneWindow）
        Window
        Window是一个抽象类，就是代表了一个窗口（与用户进行交互的窗口）
        实际上，窗口是一个宏观的思想，负责在屏幕上用于绘制各种UI元素以及响应用户的输入
        事件的一个矩形的区域。具有下面两个特点：
        独立绘制，不与其它界面相互影响；
        不会触发其它界面的输入事件；

        在Android系统中，窗口是独占一个Surface实例的显示区域，每个窗口的Surface由
        WindowManagerService分配。我们可以把Surface看做是一块画布，应用可以通过
        Canvas或者OpenGL在上面作画，绘画完成后，通过SurfaceFlinger将多块Surface按照
        特定的顺序（即Z-order）进行混合，而后再输出到FrameBuffer中，这样用户界面就可以
        显示了。

        android.view.Window这个抽象类可以看做Android中对窗口这一宏观概念所作出的约定，
        而PhoneWindow是对Window窗口的具体实现。

        Window这个抽象类包含了三个核心组件：


        初步理解，适合入门级别理解（）

        View的呈现过程。


         */
        /*
        参考 http://blog.csdn.net/tgww88/article/details/7973476

        什么是Surface？

        在 sdk文档中，对Surface的描述是：Handle onto a raw buffer that is
        being managed by the screen compositor。翻译过来就就是：由屏幕显示
        内容合成器（screen compositor）所管理的原始缓冲区的句柄（当一个应用程序
        需要引用其他系统（如数据库、操作系统）所管理的内存块或者对象时可以使用句柄，
        说白了就是一个标示，通过这个标示就可找到对应的对象）

        解释一下这句话所包含的意思：
        Surface是由屏幕显示内容合成器（screen compositor）所管理的原生缓冲的句柄

        1.通过Surface（因为Surface就是句柄）就可以获取原生缓冲区以及其中的内容。就像
        在C++语言中，可以通过一个文件的句柄，就可以获得文件的内容一样。

        2.原始缓冲区（a raw buffer）是用于保存当前窗口的像素数据的。
        一般的我们可以理解为Android中的Surface就是一个用来画图形（graphics）或者
        图像（image）的地方。

        3. 在Surface对象中有一个Canvas（画布）对象，专门用于画图。

        总结：Surface中有Canvas成员，这个成员是专门用于供程序员进行画图的场所，就
        像黑板一样；其中原始缓冲区是用来保存数据的地方；Surface本身的作用类似一个句柄，
        得到了这个句柄就可以得到其中的Canvas、原始缓冲区以及其他方面的内容。
        Surface是用来管理数据的。

        Canvas是Java层构建的数据结构，是给View用的画布。ViewGroup会把自己的Canvas拆分
        给子View。View会在onDraw方法里将图形数据绘制在它获得的Canvas上。
        而Surface是Native层构建的数据结构，是给SurfaceFlinger用的画布。它是直接被用
        来绘制到屏幕上的数据结构。

        对于我们开发者来说，一般所用的View都是在Canvas进行绘制，然后最底层的View（通常
        是DecorView）的Canvas的数据信息会转换到一个Surface上，SurfaceFlinger会将
        各个应用窗口的Surface进行合成，然后绘制到屏幕上（实际上是一个Buffer，但是我们
        开发者不用考虑这些）

        简单的说Surface对应了一块屏幕缓冲区，每个window对应一个Surface，任何
        View都要画在Surface的Canvas上。传统的view共享一块屏幕缓冲区，所有的
        绘制必须在UI线程中进行。
        通过Surface可以获得原生缓冲区以及其中内容，可以理解为Surface就是一个
        用来画图形图形的地方。把每个Windows上的View都先绘制到Surface上，然后显示
        到屏幕上。


        SurfaceView

        View的测量（Measure），布局（Layout）以及绘制（Draw）的计算量比较大。计算完
        以后再从Canvas转换成Surface中数据，然后再绘制到屏幕，这个流程比较耗时。对于常规
        的UI绘制不会有什么问题，但是像Camera的预览以及视频的播放这样的应用场景来说就不可
        接受了。
        SurfaceView就是为了解决这个问题，SurfaceView内容不再是绘制在其他的Canvas上，而是直接
        绘制在其持有的一个Surface上。由于省去了很多步骤，其绘制性能大大提高。而SurfaceView
        本身只是用来控制这个Surface的大小和位置而已。

        SurfaceView：首先SurfaceView继承自View。但是SurfaceView有自己的Surface，
        SurfaceView内嵌了一个自己的Surface，可以控制这个Surface的格式和尺寸。
        SurfaceView控制这个Surface的绘制位置。

        参考：http://forlan.iteye.com/blog/2264245

        1.定义

        可以直接从内容或者DMA等硬件接口取得图像数据，是个非常重要的绘图容器。

        它拥有独立的绘图表面，即它不与其宿主窗口共享同一个绘图表面。由于拥有独立的绘图表面，因此
        SurfaceView的UI就可以在一个独立的线程中进行绘制。

        它的特性是：可以在主线程之外的线程中向屏幕绘图，这样可以避免画图任务繁重的时候造成主线程
        阻塞， 从而提高了程序的反应速度。在游戏开发中多用到SurfaceView，游戏中的背景、人物、动画
        等等尽量在画布canvas中画出。

        SurfaceView的核心在于提供了两个线程：UI线程和渲染线程。
        所有SurfaceView和SurfaceHolder.Callback的方法都应该在UI线程里调用，一般来说就是应用
        程序主线程。渲染线程所要访问的各种变量应该作同步处理。
        由于Surface可能被销毁，它只在SurfaceHolder.Callback.surfaceCreated()和SurfaceHolder.
        Callback.surfaceDestroyed之间有效，所以要确保渲染线程访问是合法有效的Surface。

        2.实现

        首先要继承SurfaceView并实现SurfaceHolder.Callback接口
        使用接口的原因：因为使用SurfaceView有一个原则，所有的绘图工作必须得在Surface被创建之后才
        能开始（Surface--表面，这个概念在图形编程中常常被提到。基本上我们可以把它当做显存的一个映射，
        写入到Surface的内容可以被直接复制到显存从而显示出来，这使得显示速度会非常快），而在Surface被
        销毁之前必须结束。所以Callback中的surfaceCreated和surfaceDestroyed就成了绘图处理代码的边界。

        需要重写Callback的方法：
        // 在Surface的大小发生改变时触发
        public void surfaceChanged（SurfaceHolder holder，int format，int width，int height）{}

        //在创建时触发，一般在这里调用画图的线程。
        public void surfaceCreated（SurfaceHolder holder）{}

        //销毁时触发，一般在这里将画图的线程停止、释放。
        public void surfaceDestroy(SurfaceHolder holder){}

        整个过程：
        继承SurfaceView并实现SurfaceHolder.Callback接口---->SurfaceView.getHolder()获得
        SurfaceHolder对象 -----> SurfaceHolder.addCallback(callback)添加回调函数---->
        SurfaceHolder.lockCanvas()获得Canvas对象并锁定画布---->Canvas绘画---->SurfaceHolder.
        unlockCanvasAndPost(Canvas canvas)结束锁定画图，并提交改变，将图形显示。

        3.SurfaceHolder

        这里用到了一个类SurfaceHolder，可以把它当成surface的控制器，用来操纵surface。处理它的
        Canvas上画的效果和动画，控制表面，大小，像素等。
        几个需要注意的方法：
        // 给SurfaceView当前的持有者一个回调对象
        abstract void addCallback（SurfaceHolder.Callback callback）;
        // 锁定画布，一般在锁定后就可以通过其返回的画布对象Canvas，在其上面画图等操纵了。
        abstract Canvas lockCanvas();
        // 锁定画布的某个区域进行画图等..因为画完图后，会调用下面的unlockCanvasAndPost来
        改变显示内容。相对部分内存要求比较高的游戏来说，可以不用重画dirty外的其他区域
        的像素，可以提高速度。

        abstract Canvas lockCanvas(Rect dirty);
        //结束锁定画图，并提交改变
        abstract void unlockCanvasAndPost(Canvas canvas)
         */
}
