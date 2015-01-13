#include <linux/module.h>
#include <linux/kernel.h>
#include <linux/init.h>

static int __init helloInit(void)
{
    printk(KERN_INFO "Hello World 1.\n");
    printk(KERN_ALERT "Hello World 1.\n");

    /*
     *A non 0 return means init_module failed; module can't be loaded.
     */
    return 0;
}

static void __exit helloExit(void)
{
    printk(KERN_INFO "Good Bye world 1.\n");
    printk(KERN_ALERT "Good Bye world 1.\n");
}

module_init(helloInit);
module_exit(helloExit);

