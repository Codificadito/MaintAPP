package com.example.maintapp.ui

import android.app.AlertDialog
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.maintapp.R

class UpdateFragment {

    private var user: User? = null

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when(menuItem.itemId) {
            R.id.menu_delete -> {
                deleteUser()
                true
            }

            else -> {
                false
            }
        }
    }

    private fun deleteUser() {
        val dialog = AlertDialog.Builder(requireContext())

        dialog.setTitle("¿Quiere Eliminar?")
        dialog.setMessage("¿Está Seguro?")

        dialog.setNegativeButton("No") { _,_ ->
            @return@setNegativeButton
        }

        dialog.setPositiveButton("Si") {
            var userViewModel = null
            userViewModel.deleteUser(user = user!!)
        }
    }
}

// Abajo de userViewModel.deleteUser(user = user!!) hay que agregar lo siguente:
// dialog.create.show()
