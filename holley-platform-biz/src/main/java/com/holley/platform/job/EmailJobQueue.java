package com.holley.platform.job;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.holley.platform.model.EmailModel;
import com.holley.platform.service.MessageService;

/**
 * \
 * 
 * @author cheng.shen@holley.cn 发邮件任务队列
 * @param <T>
 */
public class EmailJobQueue<T> {

    private LoanTask                        task;
    private Queue<T>                        queue = new ConcurrentLinkedQueue();
    public static EmailJobQueue<EmailModel> EMAILTASK;

    public EmailJobQueue(LoanTask task) {
        super();
        this.task = task;
    }

    // 初始化任务可以传递service
    public static void init(MessageService messageService) {
        EMAILTASK = new EmailJobQueue<EmailModel>(new EmailTask(messageService));
    }

    // 添加指定队列任务
    public synchronized void offer(T model) {
        if (!queue.contains(model)) {
            queue.offer(model);
            synchronized (task.getLock()) {
                task.execute();
            }
        }
    }

    // 添加多个队列任务
    public synchronized void offer(List<T> models) {
        for (T model : models) {
            if (!queue.contains(model)) {
                queue.add(model);
            }
        }
        synchronized (task.getLock()) {
            task.execute();
        }
    }

    // 删除指定队列任务
    public synchronized void remove(T model) {
        if (queue.contains(model)) {
            queue.remove(model);
        }
    }

    public synchronized T peek() {
        return queue.peek();
    }

    // 获取任务数量
    public int size() {
        return queue.size();
    }

    public void stop() {
        task.stop();
    }
}
