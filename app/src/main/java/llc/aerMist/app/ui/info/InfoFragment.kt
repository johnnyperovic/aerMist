package llc.aerMist.app.ui.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_info.*
import llc.aerMist.app.R
import llc.aerMist.app.ui.popup.ResetAppPopup


class InfoFragment : Fragment() {
    private lateinit var resetAppDialog: ResetAppPopup


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btnResetApp.setOnClickListener {
            resetAppDialog = ResetAppPopup()
            resetAppDialog.isCancelable = false
            resetAppDialog.show(childFragmentManager, "")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

}