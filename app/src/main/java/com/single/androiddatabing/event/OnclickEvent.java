package com.single.androiddatabing.event;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.single.androiddatabing.R;

/**
 * Created by xiangcheng on 18/12/28.
 */

public class OnclickEvent {
    public void onClickFriend(View view) {
        if (view.getId() == R.id.textView) {
            Log.d("TAG", "点击了");
            Toast.makeText(view.getContext(), "button1被点击了", Toast.LENGTH_LONG).show();
        } else if (view.getId() == R.id.button) {
            Log.d("TAG", "点击了");
            Toast.makeText(view.getContext(), "button2被点击了", Toast.LENGTH_LONG).show();
        }

    }

    public void runTask(Task task) {
        task.run();
    }

    public void runTask(View view, Task task) {
        Toast.makeText(view.getContext(), "执行了传view的runTask", Toast.LENGTH_SHORT).show();
        task.run();
    }

    public void runTask(View view, Task task, boolean isRun) {
        Toast.makeText(view.getContext(), "执行了传view的runTask", Toast.LENGTH_SHORT).show();
        if (!isRun) {
            task.run();
        }
    }

    public static class Task implements Runnable {
        @Override
        public void run() {
            Log.d("TASK", "怎么就执行了Task了呢");
        }
    }
}
