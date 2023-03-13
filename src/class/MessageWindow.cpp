#include "MessageWindow.hpp"
namespace mystd
{
  using namespace std;
  MessageWindow::MessageWindow(std::string message):message(message){
    show();
  }
  void MessageWindow::show(){
    ImGui::Begin("msg window");
    ImGui::Text("message:");
    ImGui::NewLine();
    ImGui::Text("%s",message.c_str());
    ImGui::End();

  }
  MessageWindow::~MessageWindow() { 
   
    }
}