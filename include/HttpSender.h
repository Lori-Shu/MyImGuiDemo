#pragma once
#include <winsock2.h>

#include <array>
#include <iostream>
#include <memory>
#include <mutex>
#include <string>
namespace mystd{
    class HttpSender final{
        public:
        
         ~HttpSender();
        HttpSender(HttpSender &s)=delete;
        HttpSender operator=(HttpSender &s) = delete;
        
        static HttpSender& getSender();
        std::string getStringRes(std::string url);
        std::string postStringRes(std::string url,std::string jsonData);

            private : void initWindowsWSA();
        void freeWindowsWSA();
        HttpSender();
        SOCKET getSocket(std::string url);
        std::string makeGetRequest(
            std::string url);
        std::string makePostRequest(std::string url,std::string jsonData);
        void splitUrl(std::string url);
        static std::unique_ptr<HttpSender> INSTANCE_PTR;
        static std::mutex mtx;
        WSADATA wsaData;
        static constexpr int32_t bufferLength=1024;
        std::array<char,bufferLength> buffer;
        const int32_t FPOS = 6;
        const std::string GET = "GET ";
        const std::string POST = "POST ";
        const std::string HTTP_VERSION = " HTTP/1.1";
        const std::string HOST_HEADER_KEY="Host:";
        const std::string CONTENT_TYPE_HEADER = "Content-Type:application/json;charset=UTF-8\r\n";
        const std::string CONTENT_LENGTH_HEADER_KEY = "Content-Length:";
        const std::string BASIC_HEADER =
            "Accept:text/html\r\n"
            // "Accept-Encoding:gzip\r\n"
            "Connection:keep-alive\r\n"
            "Accept-Charset:utf-8\r\n";
        const std::string NEXT_ROW = "\r\n";
        std::string currentHost;
        std::string currentResourceStr;
        std::string currentAddr;
        std::string currentPort;
    };
}