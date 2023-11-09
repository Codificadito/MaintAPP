//package com.example.maintapp.ui
//
//import android.app.AlertDialog
//import android.view.Menu
//import android.view.MenuInflater
//import android.view.MenuItem
//import androidx.fragment.app.Fragment
//import com.example.maintapp.R
//
//class ListFragmentExample: Fragment() {
//
//    private fun deleteAll() {
//        val dialog = AlertDialog.Builder(requireContext())
//
//        dialog.setTitle("¿Quiere Eliminar Todos?")
//        dialog.setMessage("¿Está Seguro?")
//
//        dialog.setNegativeButton("No") { _,_ ->
//            return@setNegativeButton
//        }
//
//        dialog.setPositiveButton("Si") { _,_ ->
//            userViewModel.deleteAllTasks()
//        }
//
//        dialog.create().show()
//    }
//
//    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
//        menuInflater.inflate(R.menu.delete_menu, menu)
//    }
//
//    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
//        return when(menuItem.itemId) {
//            R.menu.delete_menu -> {
//                deleteAll()
//                true
//            }
//
//            else -> {
//                false
//            }
//        }
//    }
//
//}