#include < linux/kernel.h >
#include < linux/sched.h >
#include < linux/module.h >

int main(int argc, char* argv[])
{
	struct task_struct *task;
 
	for_each_process(task)
	{
		printk("%s [%d]\n",task->comm , task->pid);
	}
   
	return 0;
}
