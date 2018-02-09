import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import registerServiceWorker from './registerServiceWorker';

ReactDOM.render(
    <App />, document.getElementById('root')
);
registerServiceWorker();

//模块热加载，不用刷新页面就可以替换内容
if (module.hot) {
    module.hot.accept();
}