#include "GGL_ZONE.hpp"

#include <imgui.h>

#include <vector>

#include "MessageWindow.hpp"
#include<imgui_impl_vulkan.h>
namespace mystd {
using namespace std;
GGL_ZONE::GGL_ZONE() { loadTextures(); }
void GGL_ZONE::loadTextures(){
  MyTextureData cat{};
  bool ret = LoadTextureFromFile(
      "D:/cppproject/MyImguiDemo/src/resources/"
      "9bcc19297cf8efd69a9372ae5604a086.jpeg",
      &cat);
  IM_ASSERT(ret);
  imageMap["cat"] = cat;
}
void GGL_ZONE::renderWindow() {
  ImGui::Begin("My First GGL_ZONE Window", (bool*)0,
               ImGuiWindowFlags_AlwaysAutoResize | ImGuiWindowFlags_MenuBar |
                   ImGuiWindowFlags_NoCollapse);
  renderMenuBar();

  renderTab();
  // GGL_ZONE::loadTexture(tex_id,device);
  // cv::Mat mat = cv::imread(
  //     "C:/Users/24120/Pictures/Saved "
  //     "Pictures/src=http___c-ssl.duitang.com_uploads_blog_202104_22_"
  //     "20210422220415_2e4bd.jpg&refer=http___c-ssl.duitang.webp");

  // tex_id = (ImTextureID)(mat.data());
  MyTextureData& cat = imageMap["cat"];
  ImGui::Image((ImTextureID)cat.DS,
               ImVec2(cat.Width, cat.Height));
  ImGui::Text("hello ggl zone");
  static vector<char> textBuffer{'i', 'n', 'p', 'u', 't', ' ', 'y', 'o',
                                 'u', 'r', ' ', 'w', 'o', 'r', 'd', 's'};
  textBuffer.resize(1024);
  ImVec2 inputTextField(500, 200);
  ImGui::InputTextMultiline("password", textBuffer.data(), 1024, inputTextField,
                            ImGuiInputTextFlags_Multiline);
  ImGui::NewLine();
  
  // if (ImGui::Button("testBtn", ImVec2(50.0f, 20.0f))) {
  //   showMessageWindow = !showMessageWindow;
  // }

  // if (showMessageWindow) {
  //   char msg1[textBuffer.size() + 1];
  //   memcpy(msg1, textBuffer.data(), textBuffer.size());
  //   msg1[textBuffer.size()] = '\0';
  //   mystd::MessageWindow mw(msg1);
  // }
  ImGui::End();
}
MyTextureData& GGL_ZONE::getMyTextureDataByName(const char* name) { 
  return imageMap[name]; 
}
void GGL_ZONE::removeAllTexture(){
  for(auto &pair:imageMap){
    RemoveTexture(&(pair.second));
  }
}
void GGL_ZONE::renderMenuBar() {
 
  ImGui::BeginMenuBar();
 
 if( ImGui::BeginMenu("文件")){
  // ImGui::BeginMenu("文件");
  ImGui::MenuItem("另存为", NULL,nullptr);
  // ImGui::MenuItem("查看本地", nullptr, nullptr);
  // ImGui::EndMenu();
  ImGui::EndMenu();
 }
  ImGui::EndMenuBar();
 
}
void GGL_ZONE::renderTab() { 
  ImGui::BeginTabBar("切换栏");
  static bool isRenderTable=false;
  if(ImGui::TabItemButton("日志")){
  isRenderTable = !isRenderTable;
  }
  if(isRenderTable){
  renderTable();
  }

  ImGui::TabItemButton("音乐");
  ImGui::TabItemButton("视频");
  ImGui::EndTabBar();
}
void GGL_ZONE::renderTable(){
  bool ctResult = ImGui::BeginTable(
      "test table", 4, ImGuiTableFlags_Borders | ImGuiTableFlags_RowBg);
  if (ctResult) {
  } else {
  abort();
  }
  ImGui::TableSetupColumn("name", ImGuiTableColumnFlags_WidthStretch, 100.0f);

  ImGui::TableSetupColumn("age", ImGuiTableColumnFlags_WidthStretch, 100.0f);

  ImGui::TableSetupColumn("sex", ImGuiTableColumnFlags_WidthStretch, 100.0f);

  ImGui::TableSetupColumn("niub", ImGuiTableColumnFlags_WidthStretch, 100.0f);

  ImGui::TableHeadersRow();
  static bool showMessageWindow = false;
  for (uint32_t index = 0; index < 10; ++index) {
  ImGui::TableNextRow(0, 20.5f);
  ImGui::TableSetColumnIndex(0);
  ImGui::Text("Table Line");
  ImGui::Text("%c", '0' + index);
  ImGui::TableSetColumnIndex(3);
  static bool eveFlag = false;
  if (eveFlag) {
    std::string msg = "Table Line";
    msg.append({static_cast<char>('0' + index), '\0'});
    mystd::MessageWindow mw(msg);
  }
  string btnLabel("submit");
  btnLabel.append({static_cast<char>('0' + index), '\0'});
  if (ImGui::Button(btnLabel.c_str(), ImVec2(50.0f, 20.0f))) {
    eveFlag = !eveFlag;
  }
  }
  ImGui::EndTable();
}
}  // namespace mystd