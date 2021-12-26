import '../styles/globals.css'
import type { AppProps } from 'next/app'

// 모든 페이지를 Wrapping 하여 렌더링
function MyApp({ Component, pageProps }: AppProps) {
  return <Component {...pageProps} />
}

export default MyApp
