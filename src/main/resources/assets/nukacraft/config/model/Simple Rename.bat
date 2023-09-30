@echo off
setlocal enabledelayedexpansion

set "search_word=t45"
set "replace_word=x02_cryo"
set "folder_path=D:\Projects\Minecraft\nukacraft_mod\src\main\resources\assets\nukacraft\config\model\equipment\t45\"

for %%F in ("%folder_path%\%search_word%*") do (
    set "file_name=%%~nxF"
    set "new_file_name=!file_name:%search_word%=%replace_word%!"
    copy "%%F" "%folder_path%\!new_file_name!"
)