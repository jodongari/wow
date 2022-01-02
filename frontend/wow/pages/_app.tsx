import '../styles/globals.css'
import type { AppProps } from 'next/app'
import Header from "../component/header/Header";
import NavBar from "../component/header/NavBar";

// 모든 페이지를 Wrapping 하여 렌더링
function MyApp({ Component, pageProps }: AppProps) {
  return (
      <div style={{padding: "3rem 8rem"}}>
        <Header/>
        <NavBar/>
        <Component {...pageProps} />
      </div>
  )
}

export default MyApp
