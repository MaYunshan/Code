boost::mutex mutex;
boost::uint64_t sum = 0, sum1 = 0, sum2 = 0;
void add1()
{
	boost::posix_time::ptime start = boost::posix_time::microsec_clock::local_time();
	//int a = 0, b = 500000000;
	for (int i = 0; i <500000000; ++i)
	{

		sum1 += i;

	}
	//std::cout << sum1 << std::endl;
	boost::posix_time::ptime end = boost::posix_time::microsec_clock::local_time();
	std::cout << end - start << std::endl;
}

void add2()
{
	boost::posix_time::ptime start = boost::posix_time::microsec_clock::local_time();
	//int a = 500000000, b = 1000000000;
	for (int j = 500000000; j < 1000000000; ++j)
	{

		sum2 += j;

	}
	//std::cout << sum2 << std::endl;
	boost::posix_time::ptime end = boost::posix_time::microsec_clock::local_time();
	std::cout << end - start << std::endl;
}

int main()
{
	boost::posix_time::ptime start = boost::posix_time::microsec_clock::local_time();
	boost::thread t1(add1);
	boost::thread t2(add2);
	t1.join();
	t2.join();
	sum = sum1 + sum2;
	boost::posix_time::ptime end = boost::posix_time::microsec_clock::local_time();
	std::cout << end - start << std::endl;
	std::cout << sum << std::endl;
	system("pause");
	return 0;
}


//#include <boost/date_time/posix_time/posix_time.hpp> 
//#include <boost/cstdint.hpp> 
//#include <iostream> 
//#include <boost/thread.hpp> 
//
//boost::mutex mutex;
//boost::uint64_t sum = 0;
//
//void partial_sum(int from, int to)
//{
//	boost::uint64_t local_sum = 0;
//	for (int i = from; i < to; ++i)
//		local_sum += i;
//
//	mutex.lock();
//	sum += local_sum;
//	mutex.unlock();
//}
//
//int main()
//{
//	boost::posix_time::ptime start =
//		boost::posix_time::microsec_clock::local_time();
//
//	boost::thread t1(partial_sum, 0, 1000000000 / 2);
//	boost::thread t2(partial_sum, 1000000000 / 2, 1000000000);
//	t1.join();
//	t2.join();
//
//	boost::posix_time::ptime end =
//		boost::posix_time::microsec_clock::local_time();
//	std::cout << end - start << std::endl;
//
//	std::cout << sum << std::endl;
//	system("pause");
//}

