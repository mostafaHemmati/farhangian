package com.hemmati.farhangian.presentation.activationdialog

import android.content.ClipData
import android.content.ClipboardManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.DialogFragment
import com.hemmati.farhangian.R
import com.hemmati.farhangian.util.getDeviceId
import com.hemmati.farhangian.util.showToast
import kotlinx.android.synthetic.main.fragment_activation_dialog.*


class ActivationDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_activation_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        deviceId.text = getString(R.string.your_username).plus(getDeviceId())
        requestEnable.setOnClickListener {
            copyToClipboard()
        }
    }

    private fun copyToClipboard() {
        val clipboard = getSystemService(requireContext(), ClipboardManager::class.java)
        val clip = ClipData.newPlainText("deviceId", getDeviceId())
        clipboard?.setPrimaryClip(clip)
        showToast("کپی شد بفرست برا ادمین")
    }

}