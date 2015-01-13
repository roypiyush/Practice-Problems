#include <linux/module.h>
#include <linux/kernel.h>

int init_module(void)
{
    printk(KERN_INFO "Hello World 1.\n");
    printk(KERN_ALERT "Hello World 1.\n");

    /*
     *A non 0 return means init_module failed; module can't be loaded.
     */
    return 0;
}

void cleanup_module(void)
{
    printk(KERN_INFO "Good Bye world 1.\n");
    printk(KERN_ALERT "Good Bye world 1.\n");
}
