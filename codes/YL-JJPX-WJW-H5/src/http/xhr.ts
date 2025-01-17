import md5 from "js-md5";
interface myData {
  [key: string]: any;
}

function deBounce<T>(fn: T, delay: number): () => void {
  let timer: any;
  let result: any;
  return function (): void {
    const args: any[] = Array.prototype.map.call(arguments, (val) => val);
    if (timer) {
      clearTimeout(timer);
    }
    timer = setTimeout(
      () => {
        if (typeof fn === "function") {
          result = fn.apply(null, args);
        }
        clearTimeout(timer);
        return result;
      },
      delay > 0 ? delay : 100
    );
  };
}
// TODO 接口地址
// const baseUrl = "http://192.168.2.150:8057";
const baseUrl = "http://yl_jjpx_wjw_h5.local.huiminbangfu.top:8007";

export default async function myFetch(
  url = "",
  data: myData = {},
  type = "GET",
  opt?: any
) {
  type = type.toUpperCase();
  url = baseUrl + url;
  if (type == "GET") {
    let dataStr = "";
    Object.keys(data).forEach((key) => {
      dataStr += key + "=" + data[key] + "&";
    });
    url = url + "?" + dataStr;
  }
  let requestConfig: RequestInit = {
    credentials: "same-origin",
    method: type,
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json;charset=utf-8",
      Authorization: opt?.headers?.auth || "",
    },
    mode: "cors",
    cache: "force-cache",
  };

  if (type == "POST") {
    if (!data.sign) {
      data.sign = md5(localStorage.getItem("_c_z_t_phone") + "wjwtest");
    }
    requestConfig.body = JSON.stringify(data);
  }
  try {
    const response = await fetch(url, requestConfig);
    return new Promise((resolve, reject) => {
      if (response.status >= 200 && response.status < 300) {
        resolve(response.json());
      } else {
        reject(response.json());
      }
    });
  } catch (error: any) {
    throw new Error(error);
  }
}
