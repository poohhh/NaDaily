package kr.kerri.nadaily

import android.view.View
import android.os.Bundle
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kr.kerri.nadaily.databinding.ActivitySignInBinding


class SignInActivity : BaseActivity(), View.OnClickListener {

    private lateinit var database: DatabaseReference
    private lateinit var  auth: FirebaseAuth

    //private const val TAG = "GoogleActivity"
    private val RC_SIGN_IN = 99

    private lateinit var googleSignInClient: GoogleSignInClient

    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        setContentView(binding.root)

        database = Firebase.database.reference
        auth = Firebase.auth

        setProgressBar(R.id.progressBar)


        // Click listeners
        with(binding) {
            btnSignin.setOnClickListener(this@SignInActivity)

        }
    }



    // onStart. 유저가 앱에 이미 구글 로그인을 했는지 확인
    public override fun onStart() {
        super.onStart()
        val account = GoogleSignIn.getLastSignedInAccount(this)

        // Check auth on Activity start
        if (account!=null) {

        }
    } //onStart End

    override fun onClick(v: View) {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }
}