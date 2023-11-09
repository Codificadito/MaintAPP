//package com.example.maintapp.ui
//
//import android.app.AlertDialog
//import android.view.Menu
//import android.view.MenuInflater
//import android.view.MenuItem
//import androidx.core.content.ContentProviderCompat.requireContext
//import androidx.fragment.app.Fragment
//import com.example.maintapp.R
//import com.google.firebase.firestore.auth.User
//
//class UpdateFragment : Fragment() {
//
//    private var user: User? = null
//
//    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
//        menuInflater.inflate(R.menu.delete_menu, menu)
//    }
//
//    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
//        return when(menuItem.itemId) {
//            R.id.menu_delete -> {
//                deleteTask()
//                true
//            }
//
//            else -> {
//                false
//            }
//        }
//    }
//
//    private fun deleteTask() {
//        val dialog = AlertDialog.Builder(requireContext())
//
//        dialog.setTitle("¿Quiere Eliminar?")
//        dialog.setMessage("¿Está Seguro?")
//
//        dialog.setNegativeButton("No") { _,_ ->
//            return@setNegativeButton
//        }
//
//        dialog.setPositiveButton("Si") {
//            userViewModel.deleteTask(task = task!!)
//        }
//    }
//}

// Abajo de userViewModel.deleteUser(user = user!!) hay que agregar lo siguente:
// dialog.create().show()
