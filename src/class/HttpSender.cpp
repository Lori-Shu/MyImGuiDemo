#include"HttpSender.h"


namespace mystd{
    using namespace std;
    HttpSender::~HttpSender(){
        freeWindowsWSA();
    }
    unique_ptr<HttpSender> HttpSender::INSTANCE_PTR;
    mutex HttpSender::mtx;
    HttpSender& HttpSender::getSender() {
         unique_lock<mutex> lock(mtx); 
         if(INSTANCE_PTR.get()==nullptr){
            INSTANCE_PTR.reset(new HttpSender());
            return *INSTANCE_PTR;
         }
         return *INSTANCE_PTR;
    }
    std::string HttpSender::getStringRes(std::string url) {
        splitUrl(url);
        SOCKET st=getSocket(url);
        string request= makeGetRequest(url);
        int32_t sendRes= send(st,request.c_str(),request.length(),0);
        cout<<"sendRes=="<<sendRes<<endl;
        int32_t rvSize= recv(st,buffer.data(),bufferLength,0);

        cout<<string(buffer.data(),rvSize)<<endl;
        return string(buffer.data(), rvSize);
    }
    std::string HttpSender::postStringRes(std::string url,
                                          std::string jsonData){
        splitUrl(url);
        SOCKET st = getSocket(url);
        string request = makePostRequest(url,jsonData);
        int32_t sendRes = send(st, request.c_str(), request.length(), 0);
        cout << "sendRes==" << sendRes << endl;
        int32_t rvSize = recv(st, buffer.data(), bufferLength, 0);

        cout << string(buffer.data(), rvSize) << endl;
        return string(buffer.data(), rvSize);
     }
    void HttpSender::initWindowsWSA(){
         int32_t res = WSAStartup(MAKEWORD(2, 2), &wsaData);
         std::cout << "wsastartRes:" << res << std::endl;
    }
    void HttpSender::freeWindowsWSA() {
         // 终止 DLL 的使用
         int32_t res = WSACleanup();
         cout << "WSACleanup res:" << res << endl;
    }
    HttpSender::HttpSender() {
        initWindowsWSA();
    }
    SOCKET HttpSender::getSocket(std::string url) {
         SOCKET tempSocket = socket(PF_INET, SOCK_STREAM, IPPROTO_TCP);
         sockaddr_in serverAddr{};
         serverAddr.sin_family=PF_INET;
         serverAddr.sin_addr.s_addr=inet_addr(currentAddr.c_str());
         cout<<atoi(currentPort.c_str())<<endl;
         serverAddr.sin_port=htons(atoi(currentPort.c_str()));
        int32_t connRes= connect(tempSocket,reinterpret_cast<sockaddr*>(&serverAddr),sizeof(serverAddr));
        cout<<"connRes=="<<connRes<<endl;
        return tempSocket;
    }
    std::string HttpSender::makeGetRequest(std::string url){
        
         string httpGetStr = GET + currentResourceStr + HTTP_VERSION +NEXT_ROW+ HOST_HEADER_KEY +
                             currentHost+ NEXT_ROW + BASIC_HEADER + NEXT_ROW;
        return httpGetStr;                             
    }
    std::string HttpSender::makePostRequest(std::string url,
                                            std::string jsonData) {
        string httpPostStr =
            POST + currentResourceStr + HTTP_VERSION + NEXT_ROW +
            HOST_HEADER_KEY + currentHost + NEXT_ROW + CONTENT_LENGTH_HEADER_KEY +
            to_string(jsonData.length())+NEXT_ROW+
            CONTENT_TYPE_HEADER + BASIC_HEADER + NEXT_ROW + jsonData;
        cout << httpPostStr << endl;
        return httpPostStr;
     }
    void HttpSender::splitUrl(std::string url) {
         int32_t p1 = url.find('/', FPOS + 1);
         currentHost = url.substr(FPOS + 1, p1 - FPOS-1);
         currentResourceStr = url.substr(p1);
         int32_t p2=currentHost.find(':');
         currentAddr=currentHost.substr(0,p2-0);
         currentPort=currentHost.substr(p2+1);
         cout<<"host=="<<currentHost<<endl;
         cout <<"resource=="<<currentResourceStr<< endl;
         cout <<"addr=="<<currentAddr<< endl;
         cout <<"port=="<<currentPort<< endl;
    }
}
