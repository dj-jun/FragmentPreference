# FragmentPreference
Using Preferece Fragment to Realize Settings Page
## 使用PrefereceFragment实现设置页面
## 一、PreferenceFragment的布局文件
## preference.xml代码：
    <?xml version="1.0" encoding="utf-8"?>
    <PreferenceScreen xmlns:android="http://schemas.android.com/apk/res/android">
        <PreferenceCategory android:title="In-line preferences">
           <CheckBoxPreference
               android:key="checkbox preference"
                android:title="Checkbox preference"
               android:summary="This a checkbox" />
        </PreferenceCategory>
       <PreferenceCategory android:title="Dialog-based preferences">
            <EditTextPreference
               android:key="edit text preference"
               android:title="Edit Text Preference"
               android:summary="An example that uses an edit text dialog"
                android:dialogTitle="Enter your favorite animal" />
            <ListPreference
                android:key="list preference"
                android:title="List preference"
                android:summary="An example that uses a list dialog"
                android:dialogTitle="Choose one"
                android:entries="@array/example"
                android:entryValues="@array/example" />
        </PreferenceCategory>
        <PreferenceCategory android:title="Launch preferences">
            <PreferenceScreen
                android:key="screen preference"
               android:title="Screen preference"
                android:summary="Shows another screen of preferences">
                <CheckBoxPreference
                    android:key="next screen checkbox preference"
                    android:title="Toggle preference"
                    android:summary="Preference that is on the next screen but same hierarchy" />
            </PreferenceScreen>
            <PreferenceScreen
               android:title="Intent preference"
               android:summary="Launches an Activity from an Intent ">
                <intent
                    android:action="android.intent.action.VIEW"
                    android:data="http://www.baidu.com"/>>
           </PreferenceScreen>
        </PreferenceCategory>
        <!--设置项关联，选中父选项时，子选项才显示。使用dependency属性-->
        <PreferenceCategory android:title="Preference attributes">
            <CheckBoxPreference
                android:key="parent checkbox preference"
                android:title="Parent checkbox preference"
                android:summary="This is visually a parent" />
            <!-- 子类的可见类型是由样式属性定义的 -->
            <CheckBoxPreference
                android:dependency="parent checkbox preference"
                android:key="child checkbox preference"
                android:title="Child checkbox preference"
                android:summary="This is visually a child" />
        </PreferenceCategory>
    </PreferenceScreen>    
## 二、创建PreFragment,并将布局文件加载进去
## PreFragment.java代码：
    public class PreFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //从xml文件中加载选项
            addPreferencesFromResource(R.xml.preference);
        }
    }
## 三、主活动设置(MainActivity)
## MainActivity.java代码：
    public class MainActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            //加载Fragment
            FragmentManager fragmentManager=getFragmentManager();
            //开启一个新事务
            FragmentTransaction transaction=fragmentManager.beginTransaction();
            PreFragment preFragment=new PreFragment();
            transaction.add(R.id.main,preFragment);
            transaction.commit();
        }
    }
## 结果截图如下：
### 主界面：
![](https://github.com/dj-jun/FragmentPreference/blob/master/images/1.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/5)
![](https://github.com/dj-jun/FragmentPreference/blob/master/images/2.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/5)
### CheckBoxPreference界面截图：
![](https://github.com/dj-jun/FragmentPreference/blob/master/images/3.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/5)
### EditTextPreference界面截图：
![](https://github.com/dj-jun/FragmentPreference/blob/master/images/4.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/5)
### ListPreference界面截图：
![](https://github.com/dj-jun/FragmentPreference/blob/master/images/5.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/5)
### PreferenceScreen跳转到另一个PreferenceScreen界面截图：
![](https://github.com/dj-jun/FragmentPreference/blob/master/images/6.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/5)
### PreferenceScreen启动一个网页界面截图：
![](https://github.com/dj-jun/FragmentPreference/blob/master/images/7.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/5)
### CheckBox父选项;子选项，当父选项勾选时呈现界面截图：
![](https://github.com/dj-jun/FragmentPreference/blob/master/images/8.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/5)
