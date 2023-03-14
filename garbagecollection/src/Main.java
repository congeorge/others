import java.util.ArrayDeque;
import java.util.Deque;



 class superclass{

    static int xmethod()
    {
        return 5;
    }
}
public class Main extends superclass {

    static int xmethod()
    {
        return 8;
    }
    public static void main(String[] args) {
        TaskList listoftasks = new TaskList();
        TaskCreate taskCreate = new TaskCreate(listoftasks);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    try {
                        taskCreate.createTask();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        }).start();

    }


    static class TaskCreate
    {
        private TaskList list;
        public TaskCreate(TaskList taskList)
        {
            list=taskList;
        }

        public void createTask() throws InterruptedException {
            list.addTask(new Task());
        }

    }
    static class Task
    {
        private Object[] objects = new Object[2000];

        public void execute()
        {
            System.out.println("doing things");
        }

    }
    static class TaskList
    {
        private Deque<Task> tasks = new ArrayDeque<Task>();

        public void addTask(Task task) throws InterruptedException {
            tasks.add(task);
            tasks.peek().execute();
            Thread.sleep(5);
        }
    }
}

