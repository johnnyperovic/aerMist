package llc.aerMist.base.ui.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_info.*
import llc.aerMist.base.R
import llc.aerMist.base.ui.popup.AddDevicePopup
import llc.aerMist.base.ui.popup.ResetAppPopup


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