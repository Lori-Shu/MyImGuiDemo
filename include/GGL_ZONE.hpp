#pragma once
#include<vulkan/vulkan.h>
#include<imgui.h>
#include"imgui_impl_vulkan.h"
#include<unordered_map>
namespace mystd{
  class GGL_ZONE{
    public:
     GGL_ZONE();
     void loadTextures();
     void renderWindow();
     MyTextureData& getMyTextureDataByName(const char* name);
     void removeAllTexture();

    private:
     std::unordered_map<const char*, MyTextureData> imageMap;
  };
}