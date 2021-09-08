package com.github.monsterhxw.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import java.util.concurrent.ThreadFactory;

/**
 * @author XueweiHuang
 * @see <a href="https://tech.meituan.com/2016/11/18/disruptor.html">美团：高性能队列——Disruptor</a>
 * @created 2021-09-08
 */
public class DisruptorTestCase {

  private static class Element {
    private int value;

    Element() {
      this(0);
    }

    Element(int value) {
      this.value = value;
    }

    public int getValue() {
      return this.value;
    }

    public void setValue(int value) {
      this.value = value;
    }
  }

  public static void main(String[] args) {
    disruptorTest();
  }

  private static void disruptorTest() {
    ThreadFactory threadFactory = getThreadFactory("simple_thread");

    // RingBuffer 生产工厂，初始化 RingBuffer 的时候使用
    EventFactory<Element> eventFactory = getEventFactory();
    // 处理 Event 的 Handler
    EventHandler<Element> eventHandler = getEventHandler();
    // 阻塞等待策略
    BlockingWaitStrategy waitStrategy = new BlockingWaitStrategy();
    // RingBuffer 容量大小
    final int capacity = 16;
    // 单生产者模式
    ProducerType single = ProducerType.SINGLE;
    // 创建 Disruptor 对象
    Disruptor<Element> disruptor =
        new Disruptor<>(eventFactory, capacity, threadFactory, single, waitStrategy);
    // 设置 EventHandler
    disruptor.handleEventsWith(eventHandler);
    // 启动 disruptor 的线程
    disruptor.start();

    RingBuffer<Element> ringBuffer = disruptor.getRingBuffer();

    for (int i = 100; ; i++) {
      // 获取下一个可用位置的下标
      long nextSequence = ringBuffer.next();

      try {
        // 返回可用位置的元素
        Element element = ringBuffer.get(nextSequence);
        element.setValue(i);
      } finally {
        ringBuffer.publish(nextSequence);
      }
      try {
        Thread.sleep(10);
      } catch (InterruptedException ignore) {
      }
    }
  }

  private static ThreadFactory getThreadFactory(final String name) {
    return new ThreadFactory() {
      @Override
      public Thread newThread(Runnable r) {
        return new Thread(r, name);
      }
    };
  }

  private static EventFactory<Element> getEventFactory() {
    return new EventFactory<Element>() {
      @Override
      public Element newInstance() {
        return new Element();
      }
    };
  }

  private static EventHandler<Element> getEventHandler() {
    return new EventHandler<Element>() {
      @Override
      public void onEvent(Element element, long l, boolean b) throws Exception {
        System.out.println("Element: " + element.getValue());
      }
    };
  }
}
