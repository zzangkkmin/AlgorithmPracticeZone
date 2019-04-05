#use pip
#   pip install bs4 --user
#   pip install lxml --user
#   pip install requests --user

from bs4 import BeautifulSoup as bs
import requests

form_url ="https://edu.ssafy.com/comm/login/SecurityLoginForm.do"
form_header = {
    'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3',
    'Accept-Encoding': 'gzip, deflate, br',
    'Accept-Language': 'ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7',
    'Cache-Control': 'no-cache',
    'Connection': 'keep-alive',
    'Cookie': 'WMONID=gObw0yoeO8C; toast.pagefit-mode=view-all; lgnId=zzangkkmin@naver.com; JSESSIONID_HAKSAF=zk_sGYjtSHjC6k_PgQ9ACNvroYrKn-zep6EcGzjNUuBIjRj9OtU5!-604896005!278776549',
    'Host': 'edu.ssafy.com',
    'Pragma': 'no-cache',
    'Referer': 'https://edu.ssafy.com/comm/login/SecurityLogoutForm.do',
    'Upgrade-Insecure-Requests': '1',
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36'
}
session = requests.session()
response = session.get(form_url,headers=form_header)
soup = bs(response.text, 'lxml')
csrf_token = soup.select_one('meta[name="_csrf"]')['content']
login_url = "https://edu.ssafy.com/comm/login/SecurityLoginCheck.do"
login_data = {
    'userId' : 'zzangkkmin@naver.com',
    'userPwd' : 'ryghkseo!@3',
    'idSave' : 'on'
}
login_header ={
    'Accept': 'application/json, text/javascript, */*; q=0.01',
    'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
    'Origin': 'https://edu.ssafy.com',
    'Referer': 'https://edu.ssafy.com/comm/login/SecurityLoginForm.do',
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36',
    'X-CSRF-TOKEN': csrf_token,
    'X-Requested-With': 'XMLHttpRequest'
}

res = session.post(login_url,headers=login_header,data=login_data)
print(res.headers)
target_URL = "http://edu.ssafy.com/data/upload_files/crossUpload/openLrn/ebook/unzip/A20181231142031414/assets/page-images/page-7573c40c-33216b63-"
cd_p = "C:/CRTEST/"
pointer = 1
while pointer < 106:
    target = target_URL + str(pointer) + ".jpg"
    if pointer<10:
        t_imgName = cd_p + "00" + str(pointer) + ".jpg"
    elif pointer<100:
        t_imgName = cd_p + "0" + str(pointer) + ".jpg"
    else:
        t_imgName = cd_p + str(pointer) + ".jpg"
    response = session.get(target)
    with open(t_imgName,"wb") as f:
        f.write(response.content)
        f.close()
    pointer = pointer + 1
