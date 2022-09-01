Welcome developers for now we only have support for 

1 POST method with raw string. 

2 POST method with raw string and header

Will be updated with all methods asap

as a prerequesit dont forget to add 
```
<uses-permission android:name="android.permission.INTERNET"/> 
```
in manifest

to attach this module with your project first add jitpack.io dependency in your settings.gradle

add it like this

```
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

Comment this line in settings.gradle
```
repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
```

Add these 2 lines in gradle.properties
```
android.enableJetifier=true
android.useAndroidX=true
```

then just add module dependency in your app.gradle

```
dependencies {
    implementation 'com.github.Arjunbabuc92:Easy-Reterofit-Api-Calls:1.0.4'
}
```

done

Now do your api calls like below

POST API USING RAW JSON
```
class MainActivity : AppCompatActivity() {
    val gson = Gson()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //initializing api call class from the module
        val apiCalls = ApiCalls()
        //loading model class with values
        val loginRequest = LoginRequest("1234567891@getnada.com","Ancy@1998")
        //passing url, string value of request and context to getjson() method
        apiCalls.getJsonUsingRawJsonRequest(EndPoints.baseURL+EndPoints.loginEndPoint,gson.toJson(loginRequest),this){ it->
            //callback when api call is finished. If error class will automatically handle it 
            if success response will be send back with ERROR.NONE value in it.error
            if(it.error==ERROR.NONE){
                //mapping response model class with response data
                val loginResponse = gson.fromJson(it.responseData, LoginResponse::class.java)
                Log.e("sample",loginResponse.toString())
            }
        }
    }
}
```

POST API USING RAW JSON AND HEADERS

```
class MainActivity : AppCompatActivity() {
    val gson = Gson()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val apiCalls = ApiCalls()
        val changePasswordRequest = ChangePasswordRequest("12345678","123456789","123456789")
        //creating a hashmap of headers
        val map: MutableMap<String, String> = HashMap()
        map["userid"] = "101"
        apiCalls.getJsonUsingRawJsonRequestAndHeader(EndPoints.baseURL+EndPoints.changePassword,gson.toJson(changePasswordRequest),this,map){
            if(it.error== ERROR.NONE){
                val changeResponse = gson.fromJson(it.responseData, ChangePasswordResponse::class.java)
                Log.e("sample",changeResponse.toString())
            }
        }
    }
}
```

Now everything done. Thanks for using this library. if anything post it in issues
