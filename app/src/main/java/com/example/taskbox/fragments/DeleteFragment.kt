package com.example.taskbox.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.taskbox.R
import com.example.taskbox.data.TaskViewModel
import kotlinx.android.synthetic.main.fragment_delete.view.*

class DeleteFragment : Fragment() {
    private val args by navArgs<DeleteFragmentArgs>()
    private lateinit var taskViewModel: TaskViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_delete, container, false)

        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)

        view.delete_task.setText(args.currentTask.task)

        setHasOptionsMenu(true)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {
            deleteTask()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteTask() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Sim") {_,_->
            taskViewModel.deleteTask(args.currentTask)
            Toast.makeText(requireContext(),"Tarefa apagada com sucesso",Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("Não") {_,_->}
        builder.setTitle("Apagar tarefa: ${args.currentTask.task} ?")
        builder.setMessage("Você tem certeza ?")
        builder.create().show()

    }
}