Welcome developers for now we only have support for POST method with raw string. Will be updated with all methods asap

to attach this module with your project first add jitpack.io dependency in your settings.gradle

add it like this

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}

then just add module dependency in your app.gradle
...
dependencies {
    implementation 'com.github.Arjunbabuc92:Easy-Reterofit-Api-Calls:1.0.3'
}
...
done

Now do your api calls like below

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
        apiCalls.getJson(EndPoints.baseURL+EndPoints.loginEndPoint,gson.toJson(loginRequest),this){ it->
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

Now everything done. Thanks for using this library. if anything post it in issues
