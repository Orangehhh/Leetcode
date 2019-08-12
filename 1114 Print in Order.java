/*
 * @Author: Hao Liu
 * @Date: 2019-08-12 16:57:34
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-12 16:58:20
 * @Description: Multi-threading, Mutex
 */

import java.util.concurrent.*;
class Foo {
    
    Semaphore m2, m3;
    
    public Foo() {
        m2 = new Semaphore(0);
        m3 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        m2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        m2.acquire();
        printSecond.run();
        m3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
        m3.acquire();
        printThird.run();
    }
}