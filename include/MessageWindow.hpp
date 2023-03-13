#pragma once
#include<imgui.h>
#include <string>
namespace mystd{
  class MessageWindow{
    public:
      MessageWindow(std::string message);
      void show();
      ~MessageWindow();

    private:
      std::string message;
  };
}