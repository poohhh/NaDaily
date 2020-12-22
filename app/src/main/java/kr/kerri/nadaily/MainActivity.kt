package kr.kerri.nadaily

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.navigation.NavController
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import kr.kerri.nadaily.databinding.ActivityMainBinding
import kr.kerri.nadaily.fragment.MyPostsFragment
import kr.kerri.nadaily.fragment.MyTopPostsFragment
import kr.kerri.nadaily.fragment.RecentPostsFragment


class MainActivity : BaseActivity() {
//    private lateinit var navController: NavController

    private lateinit var pagerAdapter: FragmentPagerAdapter
    private lateinit var binding: ActivityMainBinding

//    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Create the adapter that will return a fragment for each section
        pagerAdapter = object : FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            private val fragments = arrayOf<Fragment>(
                RecentPostsFragment(),
                MyPostsFragment(),
                MyTopPostsFragment())

            private val fragmentNames = arrayOf(
                getString(R.string.heading_recent),
                getString(R.string.heading_my_posts),
                getString(R.string.heading_my_top_posts))

            override fun getItem(position: Int): Fragment {
                return fragments[position]
            }

            override fun getCount() = fragments.size

            override fun getPageTitle(position: Int): CharSequence? {
                return fragmentNames[position]
            }
        }

        // Set up the ViewPager with the sections adapter.
        with(binding) {
            container.adapter = pagerAdapter
            tabs.setupWithViewPager(container)

            // Button launches NewPostActivity
            fabNewPost.setOnClickListener {
                startActivity(Intent(this@MainActivity, NewPostActivity::class.java))
            }
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.action_logout) {
           FirebaseAuth.getInstance().signOut()
//            googleSignInClient.signOut()
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }

    companion object {

        private const val TAG = "MainActivity"
    }
}