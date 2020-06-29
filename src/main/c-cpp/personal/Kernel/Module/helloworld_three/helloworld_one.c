#include <linux/module.h>
#include <linux/kernel.h>
#include <linux/init.h>
#define DRIVER_AUTHOR "Piyush Roy <piyush2k13@gmail.com>"
#define DRIVER_DESC   "A Sample Driver"

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

/* 
 * Get rid of taint message by declaring code as GPL. 
 */
MODULE_LICENSE("GPL");

/*
 * Or with defines, like this:
 */
MODULE_AUTHOR(DRIVER_AUTHOR);	/* Who wrote this module? */
MODULE_DESCRIPTION(DRIVER_DESC);	/* What does this module do */

/*  
 *  This module uses /dev/testdevice.  The MODULE_SUPPORTED_DEVICE macro might
 *  be used in the future to help automatic configuration of modules, but is 
 *  currently unused other than for documentation purposes.
 */
MODULE_SUPPORTED_DEVICE("testdevice");

