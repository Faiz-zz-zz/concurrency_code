class CountDownLatch {
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();
	private int count = 0;

	public Latch(int threadCount){
		this.count = threadCount;
	}

	public void awaitZero() throws InterruptedException{
		try{
			lock.lock();
			while(count > 0) cond.await();
		}finally{
			lock.unlock();
		}
	}

	public void countDown(){
		try{
			lock.lock();
			if(--count <= 0){
				cond.signalAll();
			}
		}finally{
			lock.unlock();
		}
	}
}
