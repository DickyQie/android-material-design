## Android----Material Design之（FloatActionButton，CoordinatorLayout，CollapsingToolbarLayout，AppBarLayout 

 <p>Material Design 的一些UI 平常开发还是用的比较多的，以前没写，最近总结一下，写一篇博客，要求版本在5.0以上。</p> 
<p>主要介绍了FloatActionButton，CoordinatorLayout，CollapsingToolbarLayout，AppBarLayout，Toolbar，TabLayout，RecyclerView，CardView</p> 
<p>案例中包含了这些的使用；</p> 
<p>使用前在build.gradle 添加</p> 
<pre><code class="language-java">    compile 'com.android.support:appcompat-v7:24.2.1'
    compile 'com.jaeger.statusbaruitl:library:1.1.1'
    compile 'com.android.support:design:24.2.+'
    compile 'com.android.support:cardview-v7:24.2.1'</code></pre> 
<p><span style="font-size:15px"><strong>1：FloatActionButton（<strong>悬浮按钮</strong>）</strong></span></p>
<p>FloatActionButton是ImageButton的继承类，其用法跟普通的Button基本类&#20284;，悬浮的效果，故其使用的重点其实是在布局上。</p>
<p>效果如图：</p>
<p>　　&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img src="http://images2017.cnblogs.com/blog/1041439/201709/1041439-20170920154921150-567410476.gif" alt="" width="361" height="589"></p>
<p></p>
<pre name="code" class="html"> &lt;android.support.design.widget.FloatingActionButton
        android:id=&quot;@+id/fab&quot;
        android:layout_width=&quot;wrap_content&quot;
        android:layout_height=&quot;wrap_content&quot;
        android:layout_margin=&quot;15dp&quot;
        android:layout_gravity=&quot;bottom|right&quot;
        app:fabSize=&quot;normal&quot;
        app:elevation=&quot;6dp&quot;
        android:src=&quot;@mipmap/ic_launcher&quot;
        app:pressedTranslationZ=&quot;25dp&quot;
        /&gt;</pre><br>
<p></p>
<p>结合<strong>Snackbar</strong>使用</p>
<p><span style="font-size:14px">属性介绍：</span></p>
<p><span style="font-size:14px">1、app:borderWidth=&quot;&quot;------------------边框宽度，通常设置为0 ，用于解决Android 5.X设备上阴影无法正常显示的问题</span></p>
<p><span style="font-size:14px">2、app:backgroundTint=&quot;&quot;---------------按钮的背景颜色，不设置，默认使用theme中colorAccent的颜色</span></p>
<p><span style="font-size:14px">3、app:rippleColor=&quot;&quot;--------------------点击的边缘阴影颜色</span></p>
<p><span style="font-size:14px">4、app:elevation=&quot;&quot;----------------------边缘阴影的宽度</span></p>
<p><span style="font-size:14px">5、app:pressedTranslationZ=&quot;16dp&quot;-----点击按钮时，按钮边缘阴影的宽度，通常设置比elevation的数&#20540;大</span></p>
<p>&nbsp;</p>
<p><span style="font-size:15px"><strong>2：CoordinatorLayout&#43;AppBarLayout&#43;CollapsingToolbarLayout（工具栏伸缩折叠）</strong></span></p>
<p>实现Material Design里折叠工具栏，它继承至FrameLayout，给它设置layout_scrollFlags，</p>
<p>它可以控制包含在CollapsingToolbarLayout中的控件(如：ImageView、Toolbar)在响应layout_behavior事件时作出相应的scrollFlags滚动事件(移除屏幕或固定在屏幕顶端)。</p>
<p>效果如图：</p>
<p>&nbsp;　　　　<img src="http://images2017.cnblogs.com/blog/1041439/201709/1041439-20170927112311247-350890608.gif" alt=""></p>
<p><br>
</p>
<p>&nbsp;实现效果图的代码：</p>
<pre name="code" class="html">&lt;?xml version=&quot;1.0&quot; encoding=&quot;utf-8&quot;?&gt;
&lt;android.support.design.widget.CoordinatorLayout xmlns:android=&quot;http://schemas.android.com/apk/res/android&quot;
    xmlns:app=&quot;http://schemas.android.com/apk/res-auto&quot;
    android:id=&quot;@+id/main_content&quot;
    android:layout_width=&quot;match_parent&quot;
    android:layout_height=&quot;match_parent&quot;
    android:fitsSystemWindows=&quot;true&quot;&gt;

    &lt;android.support.design.widget.AppBarLayout
        android:id=&quot;@+id/appbar&quot;
        android:layout_width=&quot;match_parent&quot;
        android:layout_height=&quot;226dp&quot;
        android:theme=&quot;@style/ThemeOverlay.AppCompat.Dark.ActionBar&quot;
        android:fitsSystemWindows=&quot;true&quot;&gt;

        &lt;android.support.design.widget.CollapsingToolbarLayout
            android:id=&quot;@+id/collapsing_toolbar&quot;
            android:layout_width=&quot;match_parent&quot;
            android:layout_height=&quot;match_parent&quot;
            app:layout_scrollFlags=&quot;scroll|exitUntilCollapsed&quot;
            android:fitsSystemWindows=&quot;true&quot;
            app:contentScrim=&quot;?attr/colorPrimary&quot;
            app:expandedTitleMarginStart=&quot;48dp&quot;
            app:expandedTitleMarginEnd=&quot;64dp&quot;&gt;

            &lt;ImageView
                app:layout_scrollFlags=&quot;scroll|enterAlways|enterAlwaysCollapsed&quot;
                android:id=&quot;@+id/backdrop&quot;
                android:layout_width=&quot;match_parent&quot;
                android:layout_height=&quot;match_parent&quot;
                android:scaleType=&quot;centerCrop&quot;
                android:fitsSystemWindows=&quot;true&quot;
                android:src=&quot;@mipmap/zhangwo_hometop1&quot;
                app:layout_collapseMode=&quot;parallax&quot;
                /&gt;
            &lt;android.support.v7.widget.Toolbar
                android:id=&quot;@+id/toolbar&quot;
                android:layout_width=&quot;match_parent&quot;
                android:layout_height=&quot;?attr/actionBarSize&quot;
                app:popupTheme=&quot;@style/ThemeOverlay.AppCompat.Light&quot;
                app:layout_collapseMode=&quot;pin&quot; /&gt;

        &lt;/android.support.design.widget.CollapsingToolbarLayout&gt;

    &lt;/android.support.design.widget.AppBarLayout&gt;

    &lt;android.support.v4.widget.NestedScrollView
        android:layout_width=&quot;match_parent&quot;
        android:layout_height=&quot;match_parent&quot;
        app:layout_behavior=&quot;@string/appbar_scrolling_view_behavior&quot;&gt;
        &lt;android.support.v7.widget.RecyclerView
            android:id=&quot;@+id/recyclerView&quot;
            android:layout_width=&quot;match_parent&quot;
            android:layout_height=&quot;match_parent&quot;
            android:scrollbars=&quot;none&quot; /&gt;

    &lt;/android.support.v4.widget.NestedScrollView&gt;

    &lt;android.support.design.widget.FloatingActionButton
        android:id=&quot;@+id/fab&quot;
        android:layout_height=&quot;wrap_content&quot;
        android:layout_width=&quot;wrap_content&quot;
        app:layout_anchor=&quot;@id/appbar&quot;
        app:layout_anchorGravity=&quot;bottom|right|end&quot;
        android:src=&quot;@mipmap/ic_launcher&quot;
        android:layout_margin=&quot;15dp&quot;
        android:clickable=&quot;true&quot;/&gt;

&lt;/android.support.design.widget.CoordinatorLayout&gt;</pre><br>
<br>
<p><span style="font-size:15px"><strong>3：CoordinatorLayout&#43;AppBarLayout&#43;TabLayout（工具栏伸缩折叠）</strong></span></p>
<p><span style="font-size:15px">CoordinatorLayout是support.design包中的控件，它可以说是Design库中最重要的控件，</span></p>
<p><span style="font-size:14px">CoordinatorLayout&nbsp;实现了多种Material Design中提到的滚动效果。</span></p>
<p><span style="font-size:14px">效果图：</span></p>
<p><span style="font-size:14px">&nbsp;　　<img src="http://images2017.cnblogs.com/blog/1041439/201709/1041439-20170927112731184-1516798081.gif" alt="" width="365"></span></p>
<p><br>
</p>
<p>效果图布局</p>
<p></p>
<pre name="code" class="html">&lt;?xml version=&quot;1.0&quot; encoding=&quot;utf-8&quot;?&gt;
&lt;android.support.design.widget.CoordinatorLayout xmlns:android=&quot;http://schemas.android.com/apk/res/android&quot;
    xmlns:app=&quot;http://schemas.android.com/apk/res-auto&quot;
    android:layout_width=&quot;match_parent&quot;
    android:layout_height=&quot;match_parent&quot;
    android:orientation=&quot;vertical&quot;&gt;

    &lt;android.support.design.widget.AppBarLayout
        android:layout_width=&quot;match_parent&quot;
        android:layout_height=&quot;wrap_content&quot;
        android:theme=&quot;@style/ThemeOverlay.AppCompat.Dark.ActionBar&quot;&gt;

        &lt;!--app:layout_scrollFlags
        1、scroll: 所有想滚动出屏幕的view都需要设置这个flag，
        没有设置这个flag的view将被固定在屏幕顶部。
        例如，TabLayout 没有设置这个值，将会停留在屏幕顶部。
        2、enterAlways: 设置这个flag时，向下的滚动都会导致该view变为可见，启用快速“返回模式”。
        3、enterAlwaysCollapsed: 当你的视图已经设置minHeight属性又使用此标志时，
        你的视图只能已最小高度进入，只有当滚动视图到达顶部时才扩大到完整高度。
        4、exitUntilCollapsed: 滚动退出屏幕，最后折叠在顶端。--&gt;

        &lt;android.support.v7.widget.Toolbar
            android:id=&quot;@+id/appbar_toolbar&quot;
            app:layout_scrollFlags=&quot;scroll|enterAlways&quot;
            app:popupTheme=&quot;@style/Theme.AppCompat.Light&quot;
            android:layout_width=&quot;match_parent&quot;
            android:layout_height=&quot;?attr/actionBarSize&quot;
            android:background=&quot;?attr/colorPrimary&quot; /&gt;

        &lt;android.support.design.widget.TabLayout
            android:id=&quot;@+id/tabs&quot;
            app:tabGravity=&quot;fill&quot;
            app:tabMode=&quot;fixed&quot;
            android:layout_width=&quot;match_parent&quot;
            android:layout_height=&quot;wrap_content&quot; /&gt;

    &lt;/android.support.design.widget.AppBarLayout&gt;
    &lt;android.support.v4.view.ViewPager
        android:id=&quot;@+id/viewpager&quot;
        android:layout_width=&quot;match_parent&quot;
        android:layout_height=&quot;match_parent&quot;
        app:layout_behavior=&quot;@string/appbar_scrolling_view_behavior&quot; /&gt;
    &lt;!--三：滑动组件的动画，满一屏才有效果。
    app:layout_behavior=”@string/appbar_scrolling_view_behavior”
    --&gt;

&lt;/android.support.design.widget.CoordinatorLayout&gt;</pre><br>
<br>
<p></p>
